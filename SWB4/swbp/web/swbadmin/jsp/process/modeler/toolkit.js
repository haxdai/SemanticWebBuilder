// @info
//   Polyfill for SVG 2 getPathData() and setPathData() methods. Based on:
//   - SVGPathSeg polyfill by Philip Rogers (MIT License)
//     https://github.com/progers/pathseg
//   - SVGPathNormalizer by Tadahisa Motooka (MIT License)
//     https://github.com/motooka/SVGPathNormalizer/tree/master/src
//   - arcToCubicCurves() by Dmitry Baranovskiy (MIT License)
//     https://github.com/DmitryBaranovskiy/raphael/blob/v2.1.1/raphael.core.js#L1837
// @author
//   Jarosław Foksa
// @license
//   MIT License
if (!SVGPathElement.prototype.getPathData || !SVGPathElement.prototype.setPathData) {
  (function() {
    var commandsMap = {
      "Z":"Z", "M":"M", "L":"L", "C":"C", "Q":"Q", "A":"A", "H":"H", "V":"V", "S":"S", "T":"T",
      "z":"Z", "m":"m", "l":"l", "c":"c", "q":"q", "a":"a", "h":"h", "v":"v", "s":"s", "t":"t"
    };

    var Source = function(string) {
      this._string = string;
      this._currentIndex = 0;
      this._endIndex = this._string.length;
      this._prevCommand = null;
      this._skipOptionalSpaces();
    };

    var isIE = window.navigator.userAgent.indexOf("MSIE ") !== -1;

    Source.prototype = {
      parseSegment: function() {
        var char = this._string[this._currentIndex];
        var command = commandsMap[char] ? commandsMap[char] : null;

        if (command === null) {
          // Possibly an implicit command. Not allowed if this is the first command.
          if (this._prevCommand === null) {
            return null;
          }

          // Check for remaining coordinates in the current command.
          if (
            (char === "+" || char === "-" || char === "." || (char >= "0" && char <= "9")) && this._prevCommand !== "Z"
          ) {
            if (this._prevCommand === "M") {
              command = "L";
            }
            else if (this._prevCommand === "m") {
              command = "l";
            }
            else {
              command = this._prevCommand;
            }
          }
          else {
            command = null;
          }

          if (command === null) {
            return null;
          }
        }
        else {
          this._currentIndex += 1;
        }

        this._prevCommand = command;

        var values = null;
        var cmd = command.toUpperCase();

        if (cmd === "H" || cmd === "V") {
          values = [this._parseNumber()];
        }
        else if (cmd === "M" || cmd === "L" || cmd === "T") {
          values = [this._parseNumber(), this._parseNumber()];
        }
        else if (cmd === "S" || cmd === "Q") {
          values = [this._parseNumber(), this._parseNumber(), this._parseNumber(), this._parseNumber()];
        }
        else if (cmd === "C") {
          values = [
            this._parseNumber(),
            this._parseNumber(),
            this._parseNumber(),
            this._parseNumber(),
            this._parseNumber(),
            this._parseNumber()
          ];
        }
        else if (cmd === "A") {
          values = [
            this._parseNumber(),
            this._parseNumber(),
            this._parseNumber(),
            this._parseArcFlag(),
            this._parseArcFlag(),
            this._parseNumber(),
            this._parseNumber()
          ];
        }
        else if (cmd === "Z") {
          this._skipOptionalSpaces();
          values = [];
        }

        if (values === null || values.indexOf(null) >= 0) {
          // Unknown command or known command with invalid values
          return null;
        }
        else {
          return {type: command, values: values};
        }
      },

      hasMoreData: function() {
        return this._currentIndex < this._endIndex;
      },

      peekSegmentType: function() {
        var char = this._string[this._currentIndex];
        return commandsMap[char] ? commandsMap[char] : null;
      },

      initialCommandIsMoveTo: function() {
        // If the path is empty it is still valid, so return true.
        if (!this.hasMoreData()) {
          return true;
        }

        var command = this.peekSegmentType();
        // Path must start with moveTo.
        return command === "M" || command === "m";
      },

      _isCurrentSpace: function() {
        var char = this._string[this._currentIndex];
        return char <= " " && (char === " " || char === "\n" || char === "\t" || char === "\r" || char === "\f");
      },

      _skipOptionalSpaces: function() {
        while (this._currentIndex < this._endIndex && this._isCurrentSpace()) {
          this._currentIndex += 1;
        }

        return this._currentIndex < this._endIndex;
      },

      _skipOptionalSpacesOrDelimiter: function() {
        if (
          this._currentIndex < this._endIndex &&
          !this._isCurrentSpace() &&
          this._string[this._currentIndex] !== ","
        ) {
          return false;
        }

        if (this._skipOptionalSpaces()) {
          if (this._currentIndex < this._endIndex && this._string[this._currentIndex] === ",") {
            this._currentIndex += 1;
            this._skipOptionalSpaces();
          }
        }
        return this._currentIndex < this._endIndex;
      },

      // Parse a number from an SVG path. This very closely follows genericParseNumber(...) from
      // Source/core/svg/SVGParserUtilities.cpp.
      // Spec: http://www.w3.org/TR/SVG11/single-page.html#paths-PathDataBNF
      _parseNumber: function() {
        var exponent = 0;
        var integer = 0;
        var frac = 1;
        var decimal = 0;
        var sign = 1;
        var expsign = 1;
        var startIndex = this._currentIndex;

        this._skipOptionalSpaces();

        // Read the sign.
        if (this._currentIndex < this._endIndex && this._string[this._currentIndex] === "+") {
          this._currentIndex += 1;
        }
        else if (this._currentIndex < this._endIndex && this._string[this._currentIndex] === "-") {
          this._currentIndex += 1;
          sign = -1;
        }

        if (
          this._currentIndex === this._endIndex ||
          (
            (this._string[this._currentIndex] < "0" || this._string[this._currentIndex] > "9") &&
            this._string[this._currentIndex] !== "."
          )
        ) {
          // The first character of a number must be one of [0-9+-.].
          return null;
        }

        // Read the integer part, build right-to-left.
        var startIntPartIndex = this._currentIndex;

        while (
          this._currentIndex < this._endIndex &&
          this._string[this._currentIndex] >= "0" &&
          this._string[this._currentIndex] <= "9"
        ) {
          this._currentIndex += 1; // Advance to first non-digit.
        }

        if (this._currentIndex !== startIntPartIndex) {
          var scanIntPartIndex = this._currentIndex - 1;
          var multiplier = 1;

          while (scanIntPartIndex >= startIntPartIndex) {
            integer += multiplier * (this._string[scanIntPartIndex] - "0");
            scanIntPartIndex -= 1;
            multiplier *= 10;
          }
        }

        // Read the decimals.
        if (this._currentIndex < this._endIndex && this._string[this._currentIndex] === ".") {
          this._currentIndex += 1;

          // There must be a least one digit following the .
          if (
            this._currentIndex >= this._endIndex ||
            this._string[this._currentIndex] < "0" ||
            this._string[this._currentIndex] > "9"
          ) {
            return null;
          }

          while (
            this._currentIndex < this._endIndex &&
            this._string[this._currentIndex] >= "0" &&
            this._string[this._currentIndex] <= "9"
          ) {
            decimal += (this._string[this._currentIndex] - "0") * (frac *= 0.1);
            this._currentIndex += 1;
          }
        }

        // Read the exponent part.
        if (
          this._currentIndex !== startIndex &&
          this._currentIndex + 1 < this._endIndex &&
          (this._string[this._currentIndex] === "e" || this._string[this._currentIndex] === "E") &&
          (this._string[this._currentIndex + 1] !== "x" && this._string[this._currentIndex + 1] !== "m")
        ) {
          this._currentIndex += 1;

          // Read the sign of the exponent.
          if (this._string[this._currentIndex] === "+") {
            this._currentIndex += 1;
          }
          else if (this._string[this._currentIndex] === "-") {
            this._currentIndex += 1;
            expsign = -1;
          }

          // There must be an exponent.
          if (
            this._currentIndex >= this._endIndex ||
            this._string[this._currentIndex] < "0" ||
            this._string[this._currentIndex] > "9"
          ) {
            return null;
          }

          while (
            this._currentIndex < this._endIndex &&
            this._string[this._currentIndex] >= "0" &&
            this._string[this._currentIndex] <= "9"
          ) {
            exponent *= 10;
            exponent += (this._string[this._currentIndex] - "0");
            this._currentIndex += 1;
          }
        }

        var number = integer + decimal;
        number *= sign;

        if (exponent) {
          number *= Math.pow(10, expsign * exponent);
        }

        if (startIndex === this._currentIndex) {
          return null;
        }

        this._skipOptionalSpacesOrDelimiter();

        return number;
      },

      _parseArcFlag: function() {
        if (this._currentIndex >= this._endIndex) {
          return null;
        }

        var flag = false;
        var flagChar = this._string[this._currentIndex];

        this._currentIndex += 1;

        if (flagChar === "0") {
          flag = false;
        }
        else if (flagChar === "1") {
          flag = true;
        }
        else {
          return null;
        }

        this._skipOptionalSpacesOrDelimiter();
        return flag;
      }
    };

    var parsePathDataString = function(string) {
      if (!string || string.length === 0) return [];

      var source = new Source(string);
      var pathData = [];

      if (source.initialCommandIsMoveTo()) {
        while (source.hasMoreData()) {
          var pathSeg = source.parseSegment();

          if (pathSeg === null) {
            break;
          }
          else {
            pathData.push(pathSeg);
          }
        }
      }

      return pathData;
    }

    var setAttribute = SVGPathElement.prototype.setAttribute;
    var removeAttribute = SVGPathElement.prototype.removeAttribute;
    var symbols;

    if (window.Symbol) {
      symbols = {cachedPathData: Symbol(), cachedNormalizedPathData: Symbol()};
    }
    else {
      symbols = {cachedPathData: "__cachedPathData", cachedNormalizedPathData: "__cachedNormalizedPathData"};
    }

    // @info
    //   Get an array of corresponding cubic bezier curve parameters for given arc curve paramters.
    var arcToCubicCurves = function(x1, y1, x2, y2, r1, r2, angle, largeArcFlag, sweepFlag, _recursive) {
      var degToRad = function(degrees) {
        return (Math.PI * degrees) / 180;
      };

      var rotate = function(x, y, angleRad) {
        var X = x * Math.cos(angleRad) - y * Math.sin(angleRad);
        var Y = x * Math.sin(angleRad) + y * Math.cos(angleRad);
        return {x: X, y: Y};
      };

      var angleRad = degToRad(angle);
      var params = [];
      var f1, f2, cx, cy;

      if (_recursive) {
        f1 = _recursive[0];
        f2 = _recursive[1];
        cx = _recursive[2];
        cy = _recursive[3];
      }
      else {
        var p1 = rotate(x1, y1, -angleRad);
        x1 = p1.x;
        y1 = p1.y;

        var p2 = rotate(x2, y2, -angleRad);
        x2 = p2.x;
        y2 = p2.y;

        var x = (x1 - x2) / 2;
        var y = (y1 - y2) / 2;
        var h = (x * x) / (r1 * r1) + (y * y) / (r2 * r2);

        if (h > 1) {
          h = Math.sqrt(h);
          r1 = h * r1;
          r2 = h * r2;
        }

        var sign;

        if (largeArcFlag === sweepFlag) {
          sign = -1;
        }
        else {
          sign = 1;
        }

        var r1Pow = r1 * r1;
        var r2Pow = r2 * r2;

        var left = r1Pow * r2Pow - r1Pow * y * y - r2Pow * x * x;
        var right = r1Pow * y * y + r2Pow * x * x;

        var k = sign * Math.sqrt(Math.abs(left/right));

        cx = k * r1 * y / r2 + (x1 + x2) / 2;
        cy = k * -r2 * x / r1 + (y1 + y2) / 2;

        f1 = Math.asin(((y1 - cy) / r2).toFixed(9));
        f2 = Math.asin(((y2 - cy) / r2).toFixed(9));

        if (x1 < cx) {
          f1 = Math.PI - f1;
        }
        if (x2 < cx) {
          f2 = Math.PI - f2;
        }

        if (f1 < 0) {
          f1 = Math.PI * 2 + f1;
        }
        if (f2 < 0) {
          f2 = Math.PI * 2 + f2;
        }

        if (sweepFlag && f1 > f2) {
          f1 = f1 - Math.PI * 2;
        }
        if (!sweepFlag && f2 > f1) {
          f2 = f2 - Math.PI * 2;
        }
      }

      var df = f2 - f1;

      if (Math.abs(df) > (Math.PI * 120 / 180)) {
        var f2old = f2;
        var x2old = x2;
        var y2old = y2;

        if (sweepFlag && f2 > f1) {
          f2 = f1 + (Math.PI * 120 / 180) * (1);
        }
        else {
          f2 = f1 + (Math.PI * 120 / 180) * (-1);
        }

        x2 = cx + r1 * Math.cos(f2);
        y2 = cy + r2 * Math.sin(f2);
        params = arcToCubicCurves(x2, y2, x2old, y2old, r1, r2, angle, 0, sweepFlag, [f2, f2old, cx, cy]);
      }

      df = f2 - f1;

      var c1 = Math.cos(f1);
      var s1 = Math.sin(f1);
      var c2 = Math.cos(f2);
      var s2 = Math.sin(f2);
      var t = Math.tan(df / 4);
      var hx = 4 / 3 * r1 * t;
      var hy = 4 / 3 * r2 * t;

      var m1 = [x1, y1];
      var m2 = [x1 + hx * s1, y1 - hy * c1];
      var m3 = [x2 + hx * s2, y2 - hy * c2];
      var m4 = [x2, y2];

      m2[0] = 2 * m1[0] - m2[0];
      m2[1] = 2 * m1[1] - m2[1];

      if (_recursive) {
        return [m2, m3, m4].concat(params);
      }
      else {
        params = [m2, m3, m4].concat(params).join().split(",");

        var curves = [];
        var curveParams = [];

        params.forEach( function(param, i) {
          if (i % 2) {
            curveParams.push(rotate(params[i - 1], params[i], angleRad).y);
          }
          else {
            curveParams.push(rotate(params[i], params[i + 1], angleRad).x);
          }

          if (curveParams.length === 6) {
            curves.push(curveParams);
            curveParams = [];
          }
        });

        return curves;
      }
    };

    var clonePathData = function(pathData) {
      return pathData.map( function(seg) {
        return {type: seg.type, values: Array.prototype.slice.call(seg.values)}
      });
    };

    // @info
    //   Takes any path data, returns path data that consists only from absolute commands.
    var absolutizePathData = function(pathData) {
      var absolutizedPathData = [];

      var currentX = null;
      var currentY = null;

      var subpathX = null;
      var subpathY = null;

      pathData.forEach( function(seg) {
        var type = seg.type;

        if (type === "M") {
          var x = seg.values[0];
          var y = seg.values[1];

          absolutizedPathData.push({type: "M", values: [x, y]});

          subpathX = x;
          subpathY = y;

          currentX = x;
          currentY = y;
        }

        else if (type === "m") {
          var x = currentX + seg.values[0];
          var y = currentY + seg.values[1];

          absolutizedPathData.push({type: "M", values: [x, y]});

          subpathX = x;
          subpathY = y;

          currentX = x;
          currentY = y;
        }

        else if (type === "L") {
          var x = seg.values[0];
          var y = seg.values[1];

          absolutizedPathData.push({type: "L", values: [x, y]});

          currentX = x;
          currentY = y;
        }

        else if (type === "l") {
          var x = currentX + seg.values[0];
          var y = currentY + seg.values[1];

          absolutizedPathData.push({type: "L", values: [x, y]});

          currentX = x;
          currentY = y;
        }

        else if (type === "C") {
          var x1 = seg.values[0];
          var y1 = seg.values[1];
          var x2 = seg.values[2];
          var y2 = seg.values[3];
          var x = seg.values[4];
          var y = seg.values[5];

          absolutizedPathData.push({type: "C", values: [x1, y1, x2, y2, x, y]});

          currentX = x;
          currentY = y;
        }

        else if (type === "c") {
          var x1 = currentX + seg.values[0];
          var y1 = currentY + seg.values[1];
          var x2 = currentX + seg.values[2];
          var y2 = currentY + seg.values[3];
          var x = currentX + seg.values[4];
          var y = currentY + seg.values[5];

          absolutizedPathData.push({type: "C", values: [x1, y1, x2, y2, x, y]});

          currentX = x;
          currentY = y;
        }

        else if (type === "Q") {
          var x1 = seg.values[0];
          var y1 = seg.values[1];
          var x = seg.values[2];
          var y = seg.values[3];

          absolutizedPathData.push({type: "Q", values: [x1, y1, x, y]});

          currentX = x;
          currentY = y;
        }

        else if (type === "q") {
          var x1 = currentX + seg.values[0];
          var y1 = currentY + seg.values[1];
          var x = currentX + seg.values[2];
          var y = currentY + seg.values[3];

          absolutizedPathData.push({type: "Q", values: [x1, y1, x, y]});

          currentX = x;
          currentY = y;
        }

        else if (type === "A") {
          var x = seg.values[5];
          var y = seg.values[6];

          absolutizedPathData.push({
            type: "A",
            values: [seg.values[0], seg.values[1], seg.values[2], seg.values[3], seg.values[4], x, y]
          });

          currentX = x;
          currentY = y;
        }

        else if (type === "a") {
          var x = currentX + seg.values[5];
          var y = currentY + seg.values[6];

          absolutizedPathData.push({
            type: "A",
            values: [seg.values[0], seg.values[1], seg.values[2], seg.values[3], seg.values[4], x, y]
          });

          currentX = x;
          currentY = y;
        }

        else if (type === "H") {
          var x = seg.values[0];
          absolutizedPathData.push({type: "H", values: [x]});
          currentX = x;
        }

        else if (type === "h") {
          var x = currentX + seg.values[0];
          absolutizedPathData.push({type: "H", values: [x]});
          currentX = x;
        }

        else if (type === "V") {
          var y = seg.values[0];
          absolutizedPathData.push({type: "V", values: [y]});
          currentY = y;
        }

        else if (type === "v") {
          var y = currentY + seg.values[0];
          absolutizedPathData.push({type: "V", values: [y]});
          currentY = y;
        }

        else if (type === "S") {
          var x2 = seg.values[0];
          var y2 = seg.values[1];
          var x = seg.values[2];
          var y = seg.values[3];

          absolutizedPathData.push({type: "S", values: [x2, y2, x, y]});

          currentX = x;
          currentY = y;
        }

        else if (type === "s") {
          var x2 = currentX + seg.values[0];
          var y2 = currentY + seg.values[1];
          var x = currentX + seg.values[2];
          var y = currentY + seg.values[3];

          absolutizedPathData.push({type: "S", values: [x2, y2, x, y]});

          currentX = x;
          currentY = y;
        }

        else if (type === "T") {
          var x = seg.values[0];
          var y = seg.values[1]

          absolutizedPathData.push({type: "T", values: [x, y]});

          currentX = x;
          currentY = y;
        }

        else if (type === "t") {
          var x = currentX + seg.values[0];
          var y = currentY + seg.values[1]

          absolutizedPathData.push({type: "T", values: [x, y]});

          currentX = x;
          currentY = y;
        }

        else if (type === "Z" || type === "z") {
          absolutizedPathData.push({type: "Z", values: []});

          currentX = subpathX;
          currentY = subpathY;
        }
      });

      return absolutizedPathData;
    };

    // @info
    //   Takes path data that consists only from absolute commands, returns path data that consists only from
    //   "M", "L", "C" and "Z" commands.
    var reducePathData = function(pathData) {
      var reducedPathData = [];
      var lastType = null;

      var lastControlX = null;
      var lastControlY = null;

      var currentX = null;
      var currentY = null;

      var subpathX = null;
      var subpathY = null;

      pathData.forEach( function(seg) {
        if (seg.type === "M") {
          var x = seg.values[0];
          var y = seg.values[1];

          reducedPathData.push({type: "M", values: [x, y]});

          subpathX = x;
          subpathY = y;

          currentX = x;
          currentY = y;
        }

        else if (seg.type === "C") {
          var x1 = seg.values[0];
          var y1 = seg.values[1];
          var x2 = seg.values[2];
          var y2 = seg.values[3];
          var x = seg.values[4];
          var y = seg.values[5];

          reducedPathData.push({type: "C", values: [x1, y1, x2, y2, x, y]});

          lastControlX = x2;
          lastControlY = y2;

          currentX = x;
          currentY = y;
        }

        else if (seg.type === "L") {
          var x = seg.values[0];
          var y = seg.values[1];

          reducedPathData.push({type: "L", values: [x, y]});

          currentX = x;
          currentY = y;
        }

        else if (seg.type === "H") {
          var x = seg.values[0];

          reducedPathData.push({type: "L", values: [x, currentY]});

          currentX = x;
        }

        else if (seg.type === "V") {
          var y = seg.values[0];

          reducedPathData.push({type: "L", values: [currentX, y]});

          currentY = y;
        }

        else if (seg.type === "S") {
          var x2 = seg.values[0];
          var y2 = seg.values[1];
          var x = seg.values[2];
          var y = seg.values[3];

          var cx1, cy1;

          if (lastType === "C" || lastType === "S") {
            cx1 = currentX + (currentX - lastControlX);
            cy1 = currentY + (currentY - lastControlY);
          }
          else {
            cx1 = currentX;
            cy1 = currentY;
          }

          reducedPathData.push({type: "C", values: [cx1, cy1, x2, y2, x, y]});

          lastControlX = x2;
          lastControlY = y2;

          currentX = x;
          currentY = y;
        }

        else if (seg.type === "T") {
          var x = seg.values[0];
          var y = seg.values[1];

          var x1, y1;

          if (lastType === "Q" || lastType === "T") {
            x1 = currentX + (currentX - lastControlX);
            y1 = currentY + (currentY - lastControlY);
          }
          else {
            x1 = currentX;
            y1 = currentY;
          }

          var cx1 = currentX + 2 * (x1 - currentX) / 3;
          var cy1 = currentY + 2 * (y1 - currentY) / 3;
          var cx2 = x + 2 * (x1 - x) / 3;
          var cy2 = y + 2 * (y1 - y) / 3;

          reducedPathData.push({type: "C", values: [cx1, cy1, cx2, cy2, x, y]});

          lastControlX = x1;
          lastControlY = y1;

          currentX = x;
          currentY = y;
        }

        else if (seg.type === "Q") {
          var x1 = seg.values[0];
          var y1 = seg.values[1];
          var x = seg.values[2];
          var y = seg.values[3];

          var cx1 = currentX + 2 * (x1 - currentX) / 3;
          var cy1 = currentY + 2 * (y1 - currentY) / 3;
          var cx2 = x + 2 * (x1 - x) / 3;
          var cy2 = y + 2 * (y1 - y) / 3;

          reducedPathData.push({type: "C", values: [cx1, cy1, cx2, cy2, x, y]});

          lastControlX = x1;
          lastControlY = y1;

          currentX = x;
          currentY = y;
        }

        else if (seg.type === "A") {
          var r1 = seg.values[0];
          var r2 = seg.values[1];
          var angle = seg.values[2];
          var largeArcFlag = seg.values[3];
          var sweepFlag = seg.values[4];
          var x = seg.values[5];
          var y = seg.values[6];

          if (r1 === 0 || r2 === 0) {
            reducedPathData.push({type: "C", values: [currentX, currentY, x, y, x, y]});

            currentX = x;
            currentY = y;
          }
          else {
            if (currentX !== x || currentY !== y) {
              var curves = arcToCubicCurves(currentX, currentY, x, y, r1, r2, angle, largeArcFlag, sweepFlag);

              curves.forEach( function(curve) {
                reducedPathData.push({type: "C", values: curve});

                currentX = x;
                currentY = y;
              });
            }
          }
        }

        else if (seg.type === "Z") {
          reducedPathData.push(seg);

          currentX = subpathX;
          currentY = subpathY;
        }

        lastType = seg.type;
      });

      return reducedPathData;
    };

    SVGPathElement.prototype.setAttribute = function(name, value) {
      if (name === "d") {
        this[symbols.cachedPathData] = null;
        this[symbols.cachedNormalizedPathData] = null;
      }

      setAttribute.call(this, name, value);
    };

    SVGPathElement.prototype.removeAttribute = function(name, value) {
      if (name === "d") {
        this[symbols.cachedPathData] = null;
        this[symbols.cachedNormalizedPathData] = null;
      }

      removeAttribute.call(this, name);
    };

    SVGPathElement.prototype.getPathData = function(options) {
      if (options && options.normalize) {
        if (this[symbols.cachedNormalizedPathData]) {
          return clonePathData(this[symbols.cachedNormalizedPathData]);
        }
        else {
          var pathData;

          if (this[symbols.cachedPathData]) {
            pathData = clonePathData(this[symbols.cachedPathData]);
          }
          else {
            pathData = parsePathDataString(this.getAttribute("d") || "");
            this[symbols.cachedPathData] = clonePathData(pathData);
          }

          var normalizedPathData = reducePathData(absolutizePathData(pathData));
          this[symbols.cachedNormalizedPathData] = clonePathData(normalizedPathData);
          return normalizedPathData;
        }
      }
      else {
        if (this[symbols.cachedPathData]) {
          return clonePathData(this[symbols.cachedPathData]);
        }
        else {
          var pathData = parsePathDataString(this.getAttribute("d") || "");
          this[symbols.cachedPathData] = clonePathData(pathData);
          return pathData;
        }
      }
    };

    SVGPathElement.prototype.setPathData = function(pathData) {
      if (pathData.length === 0) {
        if (isIE) {
          // @bugfix https://github.com/mbostock/d3/issues/1737
          this.setAttribute("d", "");
        }
        else {
          this.removeAttribute("d");
        }
      }
      else {
        var d = "";

        for (var i = 0, l = pathData.length; i < l; i += 1) {
          var seg = pathData[i];

          if (i > 0) {
            d += " ";
          }

          d += seg.type;

          if (seg.values) {
            d += " " + seg.values.join(" ");
          }
        }

        this.setAttribute("d", d);
      }
    };
  })();
}

/****Toolkit******/
    function desc(obj, content)
    {
        var ret="";
        for (property in obj) {
            if(content && content===true)
            {
                ret+="-->"+property+"="+obj[property]+"\r\n";
            }else
            {
                ret+="-->"+property+"\r\n";
            }
        }
        //alert(ret);
    }

    var ToolKit =
    {
        svgNS:"http://www.w3.org/2000/svg",
        xlink:"http://www.w3.org/1999/xlink",
        contents:[],
        selected:[],
        resizeBox:[],
        selectBox:null,
        cmdkey:false,
        ctrlkey:false,
        shiftKey:false,
        snap2Grid:true,
        snap2GridSize:10,
        layer:null,
        tooltip:null,
        loaded:false,
        tmHandler:null,
        lineHandlers:[],
        version: "0.2.0",

        setLayer:function(layer)
        {
            var _this = ToolKit,
                _contents = _this.contents || [];
            
            _this.layer = layer;
            for (var i = _contents.length; i--;) {
                _contents[i].layer===layer ? _contents[i].show() : _contents[i].hide();
            }
        },
                
        removeLayer:function(layer)
        {
            var _this=ToolKit,
                _contents = _this.contents || [];
        
            _this.layer=layer;
            for (var i = _contents.length; i--;) {
                if(_contents[i].layer===layer) {
                    _contents[i].remove();
                }
            }
        },                

        /*Revisar*/
        getWidth:function()
        {
            return this.svg.width.baseVal ? this.svg.width.baseVal.value : this.svg.width;
        },

        getHeight:function()
        {
            return this.svg.height.baseVal ? this.svg.height.baseVal.value : this.svg.height;
        },

        setWidth:function(width)
        {
            if (this.svg.width.baseVal) {
                this.svg.width.baseVal.value=width;
            } else {
                this.svg.width=width;
            }
        },

        setHeight:function(height)
        {
            if (this.svg.height.baseVal) {
                this.svg.height.baseVal.value=height;
            } else {
                this.svg.height=height;
            }
        },         
        
        getEventX:function(evt)
        {
            var offLeft = ToolKit.svg.offsetLeft;
            return offLeft ? evt.pageX - offLeft : evt.pageX - 60;
        },
        
        getEventY:function(evt)
        {
            var offTop = ToolKit.svg.offsetTop;
            return offTop ? evt.pageY - offTop : evt.pageY - 10;
        },

        init:function(svgid, options)
        {
            var _this=this;
            _this.svg=document.getElementById(svgid);
            _this.options = options || {};

            _this.svg.oncontextmenu=function(evt)
            {
                return false;
            };

            _this.svg.onmousemove=function(evt)
            {
                var resizeObj = _this.svg.resizeObject,
                    dragObj = _this.svg.dragObject,
                    selectBox = _this.selectBox,
                    evtX = _this.getEventX(evt),
                    evtY = _this.getEventY(evt),
                    dragOffX = _this.svg.dragOffsetX,
                    dragOffY = _this.svg.dragOffsetY,
                    i;
                    
                
                if(!_this.onmousemove(evt)) return;
                _this.svg.mouseX = evtX;
                _this.svg.mouseY = evtY;
                
                if(resizeObj !== null)
                {
                    var p = resizeObj.parent,
                        sW = resizeObj.startW,
                        sH = resizeObj.startH,
                        ix = resizeObj.ix,
                        iy = resizeObj.iy;
                
                    x = evtX - dragOffX;
                    y = evtY - dragOffY;
                    
                    tx = x - p.getX();
                    ty = y - p.getY();
                    w = Math.abs(sW + tx * 2 * ix);
                    h = Math.abs(sH + ty * 2 * iy);
                    if((p.getX() - w / 2) < 0){
                        w = p.getX() * 2;
                    }
                    if((p.getY() - h / 2) < 0){
                        h = p.getY() * 2;
                    }
                    p.resize(w,h);
                    _this.updateResizeBox();

                }else if(dragObj!==null)  //dragObjects
                {
                    _this.selected.unselect=false; //si hace drag no deselecciona
                    x= evtX - dragOffX;
                    y= evtY - dragOffY;

//                    if(_this.snap2Grid)
//                    {
//                        x=Math.round(x/_this.snap2GridSize)*_this.snap2GridSize;
//                        y=Math.round(y/_this.snap2GridSize)*_this.snap2GridSize;
//                    }

                    if(_this.cmdkey) //Drag one
                    {
                        dragObj.move(x,y);
                        _this.updateResizeBox();
                    }else //drag selecteds
                    {
                        tx = x - dragObj.getX();
                        ty = y - dragObj.getY();

                        var _selected = _this.selected || [];
                        for (i = _selected.length; i--;) 
                        {                                
                            _selected[i].traslate(tx, ty);
                        }
                        _this.updateResizeBox();
                    }
                }else if(selectBox!==null) //SelectBox
                {
                    var w = evtX - dragOffX,
                        h = evtY - dragOffY,
                        x = dragOffX,
                        y = dragOffY;

                    if(w < 0)
                    {
                        x = dragOffX + w;
                        w = -w;
                    }
                    if(h < 0)
                    {
                        y = dragOffY + h;
                        h = -h;                                        
                    }

                    selectBox.setAttributeNS(null,"x",x);
                    selectBox.setAttributeNS(null,"width",w);
                    selectBox.setAttributeNS(null,"y",y);
                    selectBox.setAttributeNS(null,"height",h);
                    //_this.svg.appendChild(_this.selectBox);

                    var nodes=_this.svg.childNodes;
                    for(i=0 ; i < nodes.length ; i++)
                    {
                        var obj = nodes.item(i); 
                        if(obj.contents && obj.canSelect===true && !obj.hidden)    //Es un objeto grafico
                        {
                            var ox = obj.getX();
                            var oy = obj.getY();
                            var bb = selectBox.getBBox();
                            if ((ox-obj.getWidth()/2 > bb.x && ox+obj.getWidth()/2 < (bb.x+bb.width)) && (oy-obj.getHeight()/2 > bb.y && oy+obj.getHeight()/2 < bb.y+bb.height))
                            //if(ox>=x && ox<=x+w && oy>=y && oy<=y+h)
                            {
                                if(!obj.selected)
                                {                                                
                                    _this.selectObj(obj);
                                }
                            }else
                            {
                                if(!_this.cmdkey)
                                {
                                    if(obj.selected)
                                    {
                                        _this.unSelectObj(obj);
                                    }
                                }
                            }
                        }
                    }
                }
                _this.loaded = true;
            };
            
            _this.svg.onmousedown=function(evt)
            {
                if(!_this.onmousedown(evt))return;
                _this.removeLineHandlers();
                //SelectBox
                if(_this.svg.dragObject===null)
                {
                    var evtX = _this.getEventX(evt),
                        evtY = _this.getEventY(evt);
                
                    if(!_this.cmdkey)_this.unSelectAll();
                    
                    _this.selectBox = _this.selectBox || document.createElementNS(_this.svgNS,"rect");
                    _this.selectBox.setAttributeNS(null,"class","selectBox");
                    _this.selectBox.setAttributeNS(null,"x",evtX);
                    _this.selectBox.setAttributeNS(null,"y",evtY);
                    _this.selectBox.setAttributeNS(null,"width",0);
                    _this.selectBox.setAttributeNS(null,"height",0);
                    //_this.selectBox.setAttributeNS(null,"stroke-dasharray","4,4");
                    _this.svg.appendChild(_this.selectBox);
                    _this.svg.dragOffsetX = evtX;
                    _this.svg.dragOffsetY = evtY;
                }
                evt.preventDefault();
            };                         

            _this.svg.onmouseup=function(evt)
            {
                if(!_this.onmouseup(evt))return;
                
                var dragObject = _this.svg.dragObject,
                        ah = _this.svg.activeHandler || null;
                
                if (ah !== null) {
                    ah.snap2Grid();
                    _this.svg.activeHandler = null;
                }
                
                //Drop
                if(dragObject!==null)
                {
                    //alert(_this.selected);
                    //_this.selected
                    //desc(_this.svg.childNodes[0],true);
                    var droped=false,
                        selected = _this.selected || [],
                        i;
                    
                    var nodes = _this.svg.childNodes;
                    for (i = nodes.length; i-- && i>=0;)
                    {
                        var obj = nodes[i];
                        if(obj && obj.contents && obj===dragObject)
                        {   
                            for (;i-- && i>=0;)
                            {
                                obj = nodes[i];
                                if(obj.hidden===false && obj.inBounds && obj.inBounds(dragObject.getX(), dragObject.getY()))
                                {
                                    if(selected.indexOf(obj) < 0)
                                    {
                                        obj.onDropObjects(selected);
                                        i = 0;
                                        droped=true;
                                    }
                                }
                            }
                        }
                    }
                    if(!droped)
                    {
                        for (i = selected.length; i--;)
                        {
                            if(selected.indexOf(selected[i].parent) < 0)
                            {
                                selected[i].setParent(null);
                            }
                        }
                    }
                    
                    if(_this.snap2Grid)
                    {
                        for (i = selected.length; i--;)
                        {
                            selected[i].snap2Grid();
                        }                          
                        _this.updateResizeBox();
                    }                                                            
                }
                
                _this.svg.dragObject=null;
                _this.svg.resizeObject=null;

                //SelectBox
                if(_this.selectBox!==null)
                {
                    _this.svg.removeChild(_this.selectBox);
                    _this.selectBox=null;
                }
            };                        

            //Add Key Events
            if (options.disableKeyEvents !== undefined && options.disableKeyEvents) {
                
            } else {
                if (window.addEventListener)
                {
                    window.addEventListener('keydown', _this.keydown, true);
                    window.addEventListener('keyup', _this.keyup, true);
                }
                else if (window.attachEvent)
                {
                    window.attachEvent("onkeydown", _this.keydown);
                    window.attachEvent("onkeyup", _this.keyup);
                }
                else
                {
                    window.onkeydown= _this.keydown;  
                    window.onkeyup= _this.keyup;  
                }
            }

            _this.setWidth(1920);
            _this.setHeight(1080);
        },
        
        onmousemove:function(evt)
        {
            //implementar
            return true;
        },
        
        onmousedown:function(evt)
        {
            //implementar
            return true;
        },
        
        onmouseup:function(evt)
        {
            //implementar
            return true;
        },

        updateResizeBox:function()
        {
            var _this=ToolKit,
                i,
                resizeBox = _this.resizeBox || [];
        
            for(i=0; i < resizeBox.length; i++)
            {
                resizeBox[i].update();
            }
        },
        
        createLineHandlers:function(obj) {
            var _this = ToolKit,
                    segments = obj.getPathData(),
                //segments = obj.pathSegList,
                i, items = segments.length;

            _this.removeLineHandlers();
            if (items >= 4 ) {
                for (i = 1; i < items - 1; i++) {
                    var segment = segments[i],//segments.getItem(i),
                    handler = document.createElementNS(_this.svgNS, "use");
            
                    handler.setAttributeNS(_this.xlink,"href","#lineHandler");
                    handler.setAttributeNS(null,"style","fill:red;cursor:move;");
                    handler.layer = _this.layer;
                    handler.parent = obj;
                    handler.segment = segment;
                    handler.segmentIndex = i;
                    
                    handler.onmousedown = function(evt) {
                        _this.svg.dragOffsetX = _this.svg.mouseX - this.segment.values[0];
                        _this.svg.dragOffsetY = _this.svg.mouseY - this.segment.values[1];
                        _this.svg.activeHandler = this;
                        _this.stopPropagation(evt);
                    };
                    
                    handler.move = function(x, y) {
                        console.log("moving to: "+x+","+y);
                        var _x, _y;
                        try {
                            _x = parseFloat(""+x);
                            _y = parseFloat(""+y);
                        } catch (error) {
                            _x = _y = null;
                        }
                        if (_x !== null && _y !== null) {
                            this.setAttributeNS(null,"x", (_x - 5));
                            this.setAttributeNS(null,"y", (_y - 5));
                        }
                    };
                    
                    handler.updateSegment=function(x, y) {
                        this.segment.values[0] = x;
                        this.segment.values[1] = y;
                        var pData = obj.getPathData();
                        pData[this.segmentIndex].values[0] = this.segment.values[0] = x;
                        pData[this.segmentIndex].values[1] = this.segment.values[1] = y;
                        obj.setPathData(pData);
                    };

                    handler.snap2Grid=function() {
                        if(_this.snap2Grid) {
                            var sx = this.segment.values[0], sy = this.segment.values[1];
                            this.updateSegment(Math.round(sx/_this.snap2GridSize)*_this.snap2GridSize, Math.round(sy/_this.snap2GridSize)*_this.snap2GridSize);
                            //this.segment.values[0] = Math.round(sx/_this.snap2GridSize)*_this.snap2GridSize;
                            //this.segment.values[1] = Math.round(sy/_this.snap2GridSize)*_this.snap2GridSize;
                            this.move(this.segment.values[0], this.segment.values[1]);
                        }
                    };
                    
                    handler.getX = function() {
                        return parseFloat(this.getAttributeNS(null,"x"));
                    };
                    handler.getY = function() {
                        return parseFloat(this.getAttributeNS(null,"y"));
                    };
                    handler.move(segment.values[0], segment.values[1]);
                    _this.lineHandlers.push(handler);
                    _this.svg.appendChild(handler);
                }
            }
        },

        removeLineHandlers:function() {
            var _this = ToolKit;
            if (_this.lineHandlers && _this.lineHandlers.length) {
                var i, handlers = _this.lineHandlers,
                    nHandlers = _this.lineHandlers.length;

                for (i = nHandlers - 1; i >= 0; i--) {
                    _this.svg.removeChild(handlers[i]);
                    //_this.lineHandlers[i].remove();
                }
                _this.lineHandlers = [];
            }
        },

        createResizeBox:function(obj, ix, iy, cursor)
        {
            var _this = ToolKit,
                b = document.createElementNS(_this.svgNS,"use");
        
            b.setAttributeNS(_this.xlink,"href","#resizeBox");
            b.setAttributeNS(null,"style","cursor:"+cursor);
            b.init=function(_ix,_iy)
            {
                b.ix=_ix;
                b.iy=_iy;
                b.update();
            };
            b.setParent=function(_parent)
            {
                b.parent=_parent;
            };
            b.update=function()
            {
                if(b.parent!==undefined)
                {
                    b.setAttributeNS(null,"x",b.parent.getX()+(b.parent.getWidth()/2)*b.ix);
                    b.setAttributeNS(null,"y",b.parent.getY()+(b.parent.getHeight()/2)*b.iy);
                }
                //desc(b.sid+" "+Number(b.getAttributeNS(null,"x"))+" "+Number(b.getAttributeNS(null,"y")));
            };
            b.onmousedown=function(evt)
            {
                b.startW=b.parent.getWidth();
                b.startH=b.parent.getHeight();
                _this.svg.dragOffsetX=_this.svg.mouseX-obj.getAttributeNS(null,"x");
                _this.svg.dragOffsetY=_this.svg.mouseY-obj.getAttributeNS(null,"y");
                _this.svg.resizeObject=b;

                //Bug de chrome
                _this.stopPropagation(evt);
            };

            b.setParent(obj);
            b.init(ix,iy);
            _this.svg.appendChild(b);
            _this.resizeBox.push(b);                        
        },
                
        createToolTip:function() {
            var _this = ToolKit,
                //msgBox = document.createDocumentFragment(),//$('<div class="tooltip"></div>');
                msgBox = document.createElement("div");
                msgBox.style.display="none";
                msgBox.setAttribute("id","modelerTooltip");
                msgBox.setAttribute("class","toolTip");
                document.body.appendChild(msgBox);
            _this.tooltip=msgBox;
        },

        showTooltip:function(pos, tooltipText, width, tooltipType) {
            var _this = ToolKit,
                classNames;
            
            _this.tmHandler && clearTimeout(_this.tmHandler);
            _this.tooltip || _this.createToolTip();
            
            classNames = _this.tooltip.className.split(" ") || [];

            if (tooltipType === "Error") {
                var index = classNames.indexOf("warningToolTip");
                (index > -1) && classNames.splice(index,1);
                
                if (classNames.indexOf("errorToolTip") === -1) {
                    classNames.push("errorToolTip");
                }
            } else if (tooltipType === "Warning") {
                var index = classNames.indexOf("errorToolTip");
                (index > -1) && classNames.splice(index,1);
                
                if (classNames.indexOf("warningToolTip") === -1) {
                    classNames.push("warningToolTip");
                }
            }
            _this.tooltip.className = classNames.join(" ");
            _this.tooltip.innerHTML = '<p>'+tooltipText+'</p>';
            _this.tmHandler = setTimeout(function(){_this.tooltip.style.display="none";},3000);
            _this.tooltip.style.display="";
        },
                
        hideToolTip:function() {
            if (ToolKit.tooltip) {
                ToolKit.tooltip.style.display="none";
            }
        },

        showResizeBoxes:function()
        {
            var _this=ToolKit;
            if (_this.selected.length === 1) {
                var obj = _this.selected[0].resizeable && _this.selected[0];
                if (obj) {
                    _this.createResizeBox(obj,-1,-1,"nw-resize");
                    _this.createResizeBox(obj,0,-1,"n-resize");
                    _this.createResizeBox(obj,1,-1,"ne-resize");
                    _this.createResizeBox(obj,-1,0,"w-resize");
                    _this.createResizeBox(obj,1,0,"e-resize");
                    _this.createResizeBox(obj,-1,1,"sw-resize");
                    _this.createResizeBox(obj,0,1,"s-resize");
                    _this.createResizeBox(obj,1,1,"se-resize");
                }
            }
        },
                
        hideResizeBoxes:function()
        {
            var _this=ToolKit,
                svg = _this.svg;
            while((o=_this.resizeBox.pop())!=null)
            {
                svg.removeChild(o);
            } 
        },

        selectObj:function(obj,noShowResize)
        {
            var _this=ToolKit;
            _this.selected.push(obj);
            obj.selected=true;   
            obj.setOverClass();
            if(!noShowResize)
            {
                setTimeout(function()
                {
                        obj.moveFirst();
                    _this.showResizeBoxes();
                },10); //Se invoca en un thread para evitar problema de chrome            
            }
        },

        unSelectObj:function(obj)
        {
            var _this=ToolKit;
            var i=_this.selected.indexOf(obj);
            _this.selected.splice(i, 1);
            obj.selected=false;
            obj.setBaseClass();
            if(i>-1)
            {
                _this.hideResizeBoxes();
            }
        },

        unSelectAll:function()
        {
            var _this=ToolKit;
            while((o=_this.selected.pop())!=null)
            {
                o.setBaseClass();
                o.selected=false;
            }        
            _this.hideResizeBoxes();
        },

        keydown:function(evt)
        {
            //desc(evt,true);
            var _this=ToolKit;
            if((evt.keyCode===8 && evt.which===8) || evt.keyCode===46 && evt.which===46)
            //if(evt.keyCode==32 && evt.which==32)
            {
                try
                {
                    var selected = _this.selected,
                        i;
                    for (i = selected.length; i--;) 
                    {
                        selected[i].remove();
                    }
                    _this.unSelectAll();
                }catch(e){console.log(e);};
                _this.stopPropagation(evt);
            }else if((evt.keyCode===91 && evt.which===91) || (evt.keyCode===224 && evt.which===224))
            {
                _this.cmdkey=true;
                _this.stopPropagation(evt);
            }else if(evt.keyCode===17 && evt.which===17)
            {
                _this.ctrlkey=true;
                
//                if(_this.selected.length>0)
//                {
//                    for (var i = _this.selected.length; i--;) 
//                    {
//                        _this.selected[i].hide();
//                    } 
//                    _this.unSelectAll();
//                }else
//                {
//                    for (var i = _this.contents.length; i--;) 
//                    {
//                        _this.contents[i].show();
//                    } 
//                }
                _this.stopPropagation(evt);
            }else if(evt.keyCode===65 && evt.which===65)
            {
                if(_this.cmdkey)
                {
                    var contents = _this.contents,
                        i;
                    for (i = contents.length; i--;) 
                    {
                        if(!contents[i].hidden && contents[i].canSelect)
                        {
                            _this.selectObj(contents[i]);
                        }
                    }
                }
            } else if (evt.keyCode===16 && evt.which===16) {
                _this.shiftKey=true;
                _this.stopPropagation(evt);
            }
        },

        keyup:function(evt)
        {
            //alert("hola");
            var _this=ToolKit;
            if((evt.keyCode===91 && evt.which===91) || (evt.keyCode===224 && evt.which===224))
            {
                _this.cmdkey=false;
                _this.stopPropagation(evt);
            }else if(evt.keyCode===17 && evt.which===17)
            {
                _this.ctrlkey=false;
                _this.stopPropagation(evt);
            } else if (evt.keyCode===16 && evt.which===16) {
                _this.shiftKey=false;
                _this.stopPropagation(evt);
            }
        },                                        

        stopPropagation:function(evt)
        {
            if (evt.preventDefault) evt.preventDefault();
            if (evt.stopPropagation) evt.stopPropagation();
        },
        
        
        createConnectionPath:function(x1, y1, x2, y2, marker_start, marker_mid, marker_end, dash_array, styleClass) 
        {
            var _this = ToolKit,
                obj = document.createElementNS(_this.svgNS,"path");
        
            obj.autoAdjust = false;
            obj.lineHandlers = [];

            obj.fixed=false;
            obj.fromObject=null;
            obj.toObject=null;
            
            //obj.setAttributeNS(null, "d", "M0 0");
            if (dash_array && dash_array !== null) {
                obj.setAttributeNS(null, "stroke-dasharray", dash_array);
            }
            if (marker_start && marker_start !== null) {
                obj.setAttributeNS(null, "marker-start", "url(#"+marker_start+")");
            }
            if (marker_mid && marker_mid !== null) {
                obj.setAttributeNS(null, "marker-mid", "url(#"+marker_mid+")");
            }
            if (marker_end && marker_end !== null) {
                obj.setAttributeNS(null, "marker-end", "url(#"+marker_end+")");
            }
            if (styleClass && styleClass !== null) {
                obj.setAttributeNS(null, "class", styleClass);
            }
            //obj.resizeable=false;
            //desc(obj, true);
            obj.addPoint = function (x,y) {
                var pData = obj.getPathData(), point = [], _type=pData.length?"L":"M";
                point.push(x);
                point.push(y);
                
                pData.push({type:_type, values: point});
                //var seg = obj.createSVGPathSegLinetoAbs(x, y);
                //obj.pathSegList.appendItem(seg);
                obj.setPathData(pData);
            };
            
            obj.setStartPoint=function(x,y) {
                obj.setPoint(0,x,y);
            };
                    
            obj.setEndPoint=function(x,y) {
                obj.setPoint(obj.getPathData().length-1,x,y);
            };
            
            obj.setPoint = function(p,x,y)
            {
                var pData = obj.getPathData(), point = [];
                point.push(x);
                point.push(y);
                
                if (!pData.length && p === 0) {
                    pData = [{type:"M", values: []}];
                }
                if (pData.length && p > -1 && p < pData.length) {
                    pData[p].values = point;
                    //obj.pathSegList.getItem(p).x=x;
                    //obj.pathSegList.getItem(p).y=y;
                }
                obj.setPathData(pData);
            };
                                
            /*obj.listSegments=function() {
                var segments = obj.pathSegList,
                    i;
                for (i = 0; i < segments.numberOfItems; i++) {
                    //desc(obj.pathSegList.getItem(i),true);
                    var segment = segments.getItem(i);
                    if (segment.pathSegType === SVGPathSeg.PATHSEG_LINETO_ABS) {
                       //console.log("lineto "+segment);
                    } else if (segment.pathSegType === SVGPathSeg.PATHSEG_MOVETO_ABS) {
                       //console.log("moveto "+segment);
                    }
                }
            };*/
            
            obj.translate=function(x,y) 
            {
                var segments = obj.getPathData(), i, l;
                l = segments.length;
                
                for(i = 1; i < segments.length - 1; i++) {//Ignore start and end points
                    var point = [];
                    point.push(segments[i].values[0]+x);
                    point.push(segments[i].values[1]+y);
                    segments[i].values = point;
                }
                obj.setPathData(segments);
                /*var segments = obj.pathSegList,
                    i;
                for (i = 1; i < segments.numberOfItems-1; i++)
                {
                    var segment=segments.getItem(i);
                    segment.x=segment.x+x;
                    segment.y=segment.y+y;
                }*/
            };
            
            obj.remove=function()
            {
                //remove fromObject
                var outConns = (obj.fromObject && obj.fromObject.outConnections) || [];
                var inConns = (obj.toObject && obj.toObject.inConnections) || [];
                
                ax = outConns.indexOf(obj);
                if(obj.fromObject!==null && ax !== -1) {
                    outConns.splice(ax, 1);
                }
                
                //remove toObject
                ax = inConns.indexOf(obj);
                if(obj.toObject!==null && ax !== -1) {
                    inConns.splice(ax, 1);
                }
                
                try
                {
                    _this.svg.removeChild(obj);
                }catch(noe){console.log(noe);}
            },
            
            obj.hide=function()
            {
                obj.style.display="none";
                obj.hidden=true;
            },
            
            obj.show=function()
            {
                obj.style.display="";
                obj.hidden=false;
            },
            
            obj.setPoint(0,x1,y1);
            obj.addPoint(x2,y2);
            
            obj.setClass=function(styleC) {
                obj.setAttributeNS(null, "class", styleC);
            },
            
            obj.moveFirst = function() {
                _this.svg.appendChild(obj);
            };
            
            _this.svg.appendChild(obj);
            return obj;
        },

        createResizeObject:function(id, parent)
        {
            var _this=ToolKit;
            return _this.createObject(function(){
                var obj = document.createElementNS(_this.svgNS,"rect"); //to create a circle, for rectangle use rectangle
                obj.resizeable=true;
                //obj.setAttributeNS(_this.xlink,"href",type);
                return obj;
            }, id, parent);
        },                    

        createUseObject:function(type, id, parent)
        {
            var _this=ToolKit;
            var ret = _this.createObject(function(){
                var obj = document.createElementNS(_this.svgNS,"use"); //to create a circle, for rectangle use rectangle
                obj.setAttributeNS(_this.xlink,"href",type);
                return obj;
            }, id, parent);
            
            //Trata de establecer los valores de acuerdo al BBOX
            if(ret.getWidth()===0 && ret.getHeight()===0) {
                var bb = {x:0, y:0, width:0, height:0};
                try {
                    bb = ret.getBBox && ret.getBBox();
                    if (bb) {
                        ret.setWidth(bb.width);
                        ret.setHeight(bb.height);
                    }
                } catch(e) {
                    
                }
            }
            
            return ret;
        },

        createUseBaseObject:function(type, id, parent)
        {
            var _this=ToolKit;
            return _this.createBaseObject(function(){
                var obj = document.createElementNS(_this.svgNS,"use"); //to create a circle, for rectangle use rectangle
                obj.setAttributeNS(_this.xlink,"href",type);
                return obj;
            }, id, parent);
        },                    

        createBaseObject:function(constructor, id, parent)
        {
            var _this = ToolKit;
            var obj = constructor();

            obj.elementType="BaseObject";
            obj.text=null;
            obj.contents=[];                        
            obj.icons=[];      
            obj.inConnections=[];
            obj.outConnections=[];
            obj.canSelect=true;
            obj.hidden=false;
            obj.layer=_this.layer;

            if(id && id!==null)obj.setAttributeNS(null,"id",id);       
            
            obj.canAddToDiagram=function() {
                return true;
            };
            
            obj.canStartLink=function(link) {
                return true;
            };
            
            obj.canEndLink=function(link) {
                return true;
            };
            
            obj.canAttach=function(parent) {
                return true;
            };
            
            obj.oncontextmenu=function(evt)
            {
                return false;
            };            

            obj.setOverClass=function()
            {
                obj.setParamClass("oclass");
            };

            obj.setBaseClass=function()
            {
                obj.setParamClass("bclass");
            };

            obj.setParamClass=function(param)
            {
                var l = obj.getAttributeNS(_this.xlink,"href");
                if(l && l!==null)
                {
                    var o = document.getElementById(l.substring(1));
                    if(o !== null)
                    {
                        var s = o.getAttributeNS(null, param);
                        if(s && s !== null) { 
                            obj.setAttributeNS(null, "class", s);
                        }
                    }
                }else
                {
                    var s = obj.getAttributeNS(null, param);
                    if(s !== null) {
                        obj.setAttributeNS(null,"class",s);
                    }
                }
            };                        

            obj.setBaseClass();                        

            obj.getX=function()
            {
                return Number(obj.getAttributeNS(null,"x"));
            };

            obj.getY=function()
            {
                return Number(obj.getAttributeNS(null,"y"));
            };

            obj.setX=function(x)
            {
                obj.setAttributeNS(null,"x",x);
            };

            obj.setY=function(y)
            {
                obj.setAttributeNS(null,"y",y);
            };   

            obj.getWidth=function()
            {
                return Number(obj.getAttributeNS(null,"width"));
            };

            obj.getHeight=function()
            {
                return Number(obj.getAttributeNS(null,"height"));
            };

            obj.setWidth=function(w)
            {
                obj.setAttributeNS(null,"width",w);
            };

            obj.setHeight=function(h)
            {
                obj.setAttributeNS(null,"height",h);
            };                           

            obj.traslate=function(dx, dy)
            {
                var ox=obj.getX();
                var oy=obj.getY();
                obj.move(ox+dx, oy+dy);
            };
            
            obj.resize=function(w,h)
            {
                obj.setAttributeNS(null,"transform","translate("+(-w/2)+","+(-h/2)+")");
                obj.setWidth(w);
                obj.setHeight(h);        

                //Move Icons
                var icons = obj.icons,
                    newX = obj.getX(),
                    newY = obj.getY(),    
                    i;
            
                for (i = icons.length; i--;) 
                {
                    var icon = icons[i];
                    var pw = w / 2 * icon.posx;
                    var ph = h / 2 * icon.posy;
                    icon.obj.move(newX + pw + icon.offx, newY + ph + icon.offy);
                }

                //Cambiar tamaño del texto
                if(obj.text && obj.text!==null)obj.text.update();      
                
                //Move InConnections
                var inConnections = obj.inConnections,
                    outConnections = obj.outConnections,
                    i;
                
                for(i = inConnections.length; i--;)
                {
                    inConnections[i].updatePoints();
                }
                
                //Move OutConnections
                for(i = outConnections.length; i--;)
                {
                    outConnections[i].updatePoints();
                }
            };

            obj.move=function(x,y)
            {
                var objW = obj.getWidth(),
                    objH = obj.getHeight(),
                    thisW = _this.getWidth(),
                    thisH = _this.getHeight(),
                    contents = obj.contents || [],
                    icons = obj.icons || [],
                    inConnections = obj.inConnections || [],
                    outConnections = obj.outConnections || [],
                    i;
                //Crecemos pantalla
                if(x + objW / 2 > thisW)
                {
                    _this.setWidth(x + objW / 2);
                }
                if(y + objH / 2 > thisH)
                {
                    _this.setHeight(y + objH / 2);
                }
                
                if(obj.canSelect)
                {
                    //Validamos bordes
                    if(x - objW / 2 < 0)
                    {
                        x = objW / 2;
                    }
                    if(y - objH / 2 < 0)
                    {
                        y=objH / 2;
                    }
                }
                
                var offx=x-obj.getX();
                var offy=y-obj.getY();
                
                obj.setX(x);
                obj.setY(y);

                //Move Childs
                for (i = contents.length; i--;)
                {
                    if(!contents[i].selected)
                    {
                        contents[i].traslate(offx,offy);
                    }
                }
                //Move Icons
                for (i = icons.length; i--;)
                {
                    icons[i].obj.traslate(offx,offy);
                }

                //Move Text
                if(obj.text && obj.text!==null)
                {
                    //obj.text.traslate(offx,offy);
                    obj.text.PX=offx;
                    obj.text.PY=offy;
                    obj.text.update();
                    var spans = obj.text.childNodes,
                        _text = obj.text;
                    
                    for (i = spans.length; i--;)
                    {
                        spans[i].setAttributeNS(null,"x",_text.getX());
                    }
                }
                
                var segments, segment, l = inConnections.length;
                //Recalculate endPoint of inconnections
                for(i = l; i--;) {
                    segments = inConnections[i].getPathData();
                    if (inConnections[i].fixed && segments.length === 4) { //Modeler fixed connections have always 4 points
                        var point = [];
                        point.push(segments[2].values[0]+offx);
                        point.push(segments[2].values[1]+offy);
                        segments[2].values = point;
                        inConnections[i].setPathData(segments);
                    }
                    inConnections[i].setEndPoint(x, y);
                    /*segments = inConnections[i].pathSegList;
                    if (inConnections[i].fixed && segments.length===4) { 
                        segment=segments.getItem(2);
                        segment.x=segment.x+offx;
                        segment.y=segment.y+offy;
                    }
                    inConnections[i].setEndPoint(x,y);*/
                }
                
                //Recalculate endPoint of outConnections and translate points acoordingly
                l = outConnections.length;
                for(i = l; i--;) {
                    segments = outConnections[i].getPathData();
                    if (outConnections[i].fixed && segments.length===4) { //Modeler fixed connections have always 4 points
                        var point = [];
                        point.push(segments[1].values[0]+offx);
                        point.push(segments[1].values[1]+offy);
                        segments[1].values = point;
                        outConnections[i].setPathData(segments);
                    }
                    outConnections[i].setStartPoint(x, y);
                    /*segments = outConnections[i].pathSegList;
                    if (outConnections[i].fixed && segments.length===4) { //Modeler fixed connections have always 4 points
                        segments = outConnections[i].pathSegList;
                        segment=segments.getItem(1);
                        segment.x=segment.x+offx;
                        segment.y=segment.y+offy;
                    }
                    outConnections[i].setStartPoint(x,y);*/
                }
            };

            obj.remove = function(all) {
                if(!all)
                {
                    //En algunos casos, el parent es nulo, es decir, el canvas
                    var parent = obj.parent;
                    if (parent && parent !== null) 
                    {
                        while ((ax = parent.contents.indexOf(obj)) !== -1) {
                            parent.contents.splice(ax, 1);
                        }
                    }
                    //elimina el objeto de contents
                    while ((ax = _this.contents.indexOf(obj)) !== -1) {
                        _this.contents.splice(ax, 1);
                    }
                }
                
                var contents = obj.contents || [],
                    icons = obj.icons || [],
                    inConnections = obj.inConnections || [],
                    outConnections = obj.outConnections || [],
                    i;
            
                for (i = contents.length; i--;)
                {
                    contents[i].remove(true);
                }
                
                //Elimina Iconos
                for (i = icons.length; i--;)
                {
                    icons[i].obj.remove();
                }

                //Elimina Texto
                if(obj.text && obj.text!==null)obj.text.remove();
                
                //Eliminar Conexiones
                //Move InConnections
                for(i = inConnections.length; i--;)
                {
                    inConnections[i].remove();
                }                
                
                //Move OutConnections
                for(i = outConnections.length; i--;)
                {
                    outConnections[i].remove();
                }                  
                
                try
                {
                    _this.svg.removeChild(obj);
                }catch(noe){}
                
                //_this.unSelectObj(obj);
                if(_this.selected.indexOf(obj)>-1)
                {
                    _this.hideResizeBoxes();
                }                
                return this;
            };
            
            obj.hide = function() {
                
                obj.style.display="none";
                obj.hidden=true;
                
                var contents = obj.contents || [],
                    icons = obj.icons || [],
                    inConnections = obj.inConnections || [],
                    outConnections = obj.outConnections || [],
                    i;
            
                for (i = contents.length; i--;) {
                    contents[i].hide();
                }
                
                //Elimina Iconos
                for (i = icons.length; i--;) {
                    icons[i].obj.hide();
                }
                //Elimina Texto
                if(obj.text && obj.text!==null)obj.text.hide();
                
                //Eliminar Conexiones
                //Move InConnections
                for(i = inConnections.length; i--;) {
                    inConnections[i].hide();
                }                
                
                //Move OutConnections
                for(i = outConnections.length; i--;) {
                    outConnections[i].hide();
                }                  
                
                //_this.unSelectObj(obj);
                if(_this.selected.indexOf(obj)>-1) {
                    _this.hideResizeBoxes();               
                }
                return this;
            };     
            
            obj.show = function(all) {
                
                obj.style.display="";
                obj.hidden=false;
                var contents = obj.contents || [],
                    icons = obj.icons || [],
                    inConnections = obj.inConnections || [],
                    outConnections = obj.outConnections || [],
                    i;
                
                for (i = contents.length; i--;) {
                    contents[i].show();
                }
                
                //Elimina Iconos
                for (i = icons.length; i--;) {
                    icons[i].obj.show();
                }
                //Elimina Texto
                if(obj.text && obj.text!==null)obj.text.show();
                
                //Eliminar Conexiones
                //Move InConnections
                for(i = inConnections.length; i--;) {
                    inConnections[i].show();
                }                
                
                //Move OutConnections
                for(i = outConnections.length; i--;) {
                    outConnections[i].show();
                }                  
                return this;
            };               
            
            //Mueve el elemento al primer plano
            obj.moveFirst = function()
            {
                //alert("obj:"+obj.icons.length);
                _this.svg.appendChild(obj);
                var icons = obj.icons || [],
                    contents = obj.contents || [],
                    inConnections = obj.inConnections || [],
                    outConnections = obj.outConnections || [],
                    i;
                
                //mueve Iconos
                for (i = icons.length; i--;) {
                    icons[i].obj.moveFirst();
                }
                
                //mueve texto
                if(obj.text && obj.text!==null)obj.text.moveFirst();
                
                //mueve contenidos
                for (i = contents.length; i--;) {
                    contents[i].moveFirst();
                }
                
                //mueve conexiones
                for (i = inConnections.length; i--;) {
                    inConnections[i].moveFirst();
                }
                
                for (i = outConnections.length; i--;) {
                    outConnections[i].moveFirst();
                }
            };
            
            obj.setParent = function(newParent)
            {
                if(obj.parent)
                {
                    while ((ax = obj.parent.contents.indexOf(obj)) !== -1) {
                        obj.parent.contents.splice(ax, 1);
                    }
                }
                
                if(newParent && newParent!==null)
                {
                    if (newParent.contents.indexOf(obj) === -1) {
                        newParent.contents.push(obj);
                        obj.parent=newParent;
                    }
                }else
                {
                    if (_this.contents.indexOf(obj) < 0) {
                        _this.contents.push(obj);
                        //obj.parent=_this;
                    }
                    obj.parent=null;
                }
            };
            
            obj.isChild = function(parent)
            {
                var p = obj.parent;
                if(p !== null)
                {
                    if(p === parent)return true;
                    else
                    {
                        if(p.isChild)
                        {
                            return p.isChild(parent);
                        }
                        return false;
                    }
                }
                return false;
            };
            
            //pos validas del 1 al 9, 1=esquina superior izquierda, 5=centro, 9=esquina inferior derecha
            obj.addIcon=function(type,posx,posy,offx,offy)
            {
                var iobj=_this.createUseBaseObject(type,null,null);
                iobj.canSelect=false;
                iobj.onmousedown=function(evt)
                {
                    obj.onmousedown(evt);
                };
                iobj.onmouseup=function(evt)
                {
                    obj.onmouseup(evt);
                };      
                iobj.onmousemove=function(evt)
                {
                    obj.onmousemove(evt);
                };
                iobj.ondblclick=function(evt)
                {
                    obj.ondblclick(evt);
                };                
                var icon={obj:iobj,posx:posx,posy:posy,offx:offx,offy:offy};
                obj.icons.push(icon);
                return icon;

            };

            //pos validas del 1 al 9, 1=esquina superior izquierda, 5=centro, 9=esquina inferior derecha
            obj.setText=function(text,posx,posy,width,orientation)
            {
                if(obj.text && obj.text!==null)obj.text.remove();
                obj.text=_this.createText(text,obj);
                obj.text.textPX=posx;
                obj.text.textPY=posy;
                obj.text.textW=width;
                obj.text.textO=orientation;
                obj.text.update();
            };  
            
            obj.onDropObjects=function(objs)
            {
                for (var i = objs.length; i--;)
                {
                    if(objs.indexOf(objs[i].parent) < 0 && objs[i].canAttach(obj))
                    {
                        objs[i].setParent(obj);
                    }
                }
            };
            
            obj.inBounds=function(x,y)
            {
                return (obj.getWidth()/2-(Math.abs(obj.getX()-x))>=0 && (obj.getHeight()/2-Math.abs(obj.getY()-y))>=0);
            };
            
            obj.addInConnection=function(connectionPath)
            {
                var conns = obj.inConnections;
                if (conns.indexOf(connectionPath) === -1) {
                    connectionPath.layer = obj.layer;
                    conns.push(connectionPath);
                    connectionPath.toObject=obj;
                    connectionPath.setEndPoint(obj.getX(),obj.getY());
                }
                
            };
            
            obj.removeInConnection=function(connectionPath) {
                var conns = obj.inConnections;
                var idx = conns.indexOf(connectionPath);
                if (idx > -1) {
                    connectionPath.toObject = null;
                    conns.splice(idx);
                }
            };
            
            obj.addOutConnection=function(connectionPath)
            {
                var conns = obj.outConnections;
                if (conns.indexOf(connectionPath) === -1) {
                    connectionPath.layer = obj.layer;
                    conns.push(connectionPath);
                    connectionPath.fromObject=obj;
                    connectionPath.setStartPoint(obj.getX(),obj.getY());
                }
            };
            
            obj.removeOutConnection=function(connectionPath) {
                var conns = obj.outConnections;
                var idx = conns.indexOf(connectionPath);
                if (idx !== -1) {
                    connectionPath.fromObject = null;
                    conns.splice(idx);
                }
            };
            
            obj.snap2Grid=function()
            {
                if(_this.snap2Grid)
                {
                    obj.move(Math.round(obj.getX()/_this.snap2GridSize)*_this.snap2GridSize,Math.round(obj.getY()/_this.snap2GridSize)*_this.snap2GridSize);
                }
            };
            
            obj.setParent(parent);
            if(_this.svg)
            {
                _this.svg.appendChild(obj);
            }
            
            /*if(obj.getWidth()===0 && obj.getHeight()===0) {
                console.log("getting bbox");
                console.log(obj);
                var bb = {x:0, y:0, width:0, height:0};
                try {
                    bb = obj.getBBox && obj.getBBox();
                    if (bb) {
                        console.log(bb);
                        obj.setWidth(bb.width);
                        obj.setHeight(bb.height);
                    }
                } catch(e) {
                    console.log(e);
                }
            }*/
            
            return obj;
        },

        createObject:function(constructor, id, parent)
        {
            var _this=ToolKit;
            var obj=_this.createBaseObject(constructor, id, parent);
            
            obj.onmousedown=function(evt)
            {
                //console.log(evt);
                if(obj.mousedown(evt))
                {
                    obj.startX=_this.getEventX(evt);
                    obj.startY=_this.getEventY(evt);
                    _this.svg.dragOffsetX=_this.svg.mouseX-obj.getAttributeNS(null,"x");
                    _this.svg.dragOffsetY=_this.svg.mouseY-obj.getAttributeNS(null,"y");
                    _this.svg.dragObject=obj;
                    obj.select(true);
                }
            };

//            obj.onmousemove=function(evt)
//            {
//                //console.log("id:"+obj.getAttributeNS(null,"id"));                            
//                if(obj.mousemove(evt))
//                {
//                    //
//                }
//            };

//            obj.mousemove=function(evt)
//            {
//                //Sobreescribir
//                return true;
//            };  

            obj.select=function(down)
            {
                //desc(obj.getBBox(),true);
                var _this=ToolKit,
                    selected = _this.selected;
            
                if(down) {
                    var i = selected.indexOf(obj);
                    if(i < 0) {
                        if(!_this.cmdkey) {//deselect all
                            _this.unSelectAll();
                        }
                        //select one
                        _this.selectObj(obj);
                    } else {
                        //can unselect
                        selected.unselect=true;
                    }
                } else {
                    if(_this.cmdkey && selected.unselect) {//unselect one
                        _this.unSelectObj(obj);
                    }                                 
                    selected.unselect=false;
                }
            };

            obj.mousedown=function(evt)
            {
                //Sobreescribir
                return true;
            };

            obj.onmouseup=function(evt)
            {
                if(obj.mouseup(evt))
                {
                    obj.select(false);
                }

                //if(_this.selected.length==1 && obj.startX==_this.getEventX(evt) && obj.startY==_this.getEventY(evt))
                //{
                //    //evento click de objeto
                //}
            };

            obj.mouseup=function(evt)
            {
                //Sobreescribir
                return true;
            };    
            
            obj.onclick=function(evt)
            {
                if(this.mouseclick(evt))
                {

                }
                //return this.mouseclick(evt);
            };

            obj.mouseclick=function(evt)
            {
                //Sobre escribir
                return true;
            };
            return obj;
        },

        createText:function(text,parent)
        {
            var _this = ToolKit;
            var obj=_this.createBaseObject(function(){
                var tx = document.createElementNS(_this.svgNS,"text"); //to create a circle, for rectangle use rectangle
                //tx.appendChild(document.createTextNode(text));
                tx.setAttributeNS(null,"text-anchor","middle");
                tx.setAttributeNS(null,"font-size","11");
                tx.setAttributeNS(null,"font-family","Verdana, Geneva, sans-serif");
                return tx;
            }, null, null);                  
            obj.value=text;                                     //Valor de la caja de texto
            obj.canSelect=false;
            obj.setAttributeNS(null,"class","textLabel");
            obj.onmousedown=function(evt)
            {
                //desc(evt,true);
                parent.onmousedown(evt);
            }; 
            
            obj.onmouseup=function(evt) {
                parent.onmouseup && parent.onmouseup(evt);
            };  
            
            obj.onmousemove=function(evt) {
                parent.onmousemove && parent.onmousemove(evt);
            };              

            parent.ondblclick=function(evt) {
                obj.ondblclick(evt);
            };

            obj.ondblclick=function(evt) {
                var txt = prompt("Texto:",obj.value);                  
                if(txt && txt!==null)
                {
                    obj.value=txt;
                    obj.update();
                }
            };

            obj.update=function()
            {
                var text_element = obj;
                var dy=10;
                var words = text_element.value.split(' ');
                var start_x = text_element.getX();
                
                //Eliminar childs
                var child=null;
                while((child=text_element.firstChild)!=null)
                {
                    text_element.removeChild(child);
                }

                var tspan_element = document.createElementNS(_this.svgNS, "tspan");	// Create first tspan element
                tspan_element.setAttributeNS(null, "x", start_x);
                var text_node = document.createTextNode(words[0]);			// Create text in tspan element

                tspan_element.appendChild(text_node);							// Add tspan element to DOM
                text_element.appendChild(tspan_element);						// Add text to tspan element
                var lin=1;
                
                var w=parent.getWidth();
                if(obj.textW)w=obj.textW;
                
                for(var i=1; i<words.length; i++)
                {
                    var len = tspan_element.firstChild.data.length;				// Find number of letters in string
                    tspan_element.firstChild.data += " " + words[i];			// Add next word
                    
                    if (tspan_element.getComputedTextLength() > w-10)
                    {
                        tspan_element.firstChild.data = tspan_element.firstChild.data.slice(0, len);	// Remove added word

                        var tspan_element = document.createElementNS(_this.svgNS, "tspan");		// Create new tspan element
                        tspan_element.setAttributeNS(null, "x", start_x);
                        tspan_element.setAttributeNS(null, "dy", dy);
                        text_node = document.createTextNode(words[i]);
                        tspan_element.appendChild(text_node);
                        text_element.appendChild(tspan_element);
                        lin++;
                    }
                }
                
                var offy=0;
                if(obj.textPY)offy=obj.textPY*(parent.getHeight()/2+lin*dy/2+dy/2);
                text_element.setY(parent.getY()+dy-lin*dy/2+offy);
                
                var offx=0;
                if(obj.textPX)offx=obj.textPX*((w/2)+dy/2);
                text_element.setX(parent.getX()+offx);
                
                if(obj.textO===2) {
                    text_element.setAttributeNS(null, "transform", "rotate(-90,"+text_element.getX()+","+text_element.getY()+")");
                    //text_element.setAttributeNS(null, "style", "writing-mode:tb");
                }
            };

            return obj;
        }
    };

/*function isNumeric(n) {
    return !isNaN(parseFloat(n)) && isFinite(n);
}

SVGPoint = function(vx, vy) {
    var ret = {x: vx, y:vy};
    ret.compareTo = function(point) {
        
    };
    
    ret.add = function(ix, iy) {
        if (isNumeric(x) && isNumeric(y)) {
            this.x += ix;
            this.y += iy;
        }
    };
    
    ret.toCoordArray = function() {
        return [this.x, this.y];
    };
    
    return ret;
};

SVGPath = function() {
    var ret = {}, element, dirty = false,
        points = [];
    
    ret.createElement = function() {
        element = document.createElementNS(ToolKit.svgNS, "path");
    };
    
    ret.addSVGPathSegLinetoAbs = function(x, y) {
        if (isNumeric(x) && isNumeric(y)) {
           var point = SVGPoint(x,y);
           points.push({type: "L", values:point.toCoordArray()});
        }
    };
    
    ret.addPoint = function(i, p, t) {
        var tp = t||"L",
            pt = {type: tp, values: p.toCoordArray()};
        
        if (!points.length) {
            points.push(pt);
        } else {
            points.splice(i,0,pt);
        }
    };
    
    ret.pushPoint = function(point, type) {
      dirty = !0;
      points.push(point);
    };
    
    ret.update = function() {
        if (!element) this.createElement();
        if (dirty) {
            dirty = !1;
        }
    };
    
    ret.setArrow = function (type) {
      dirty = !0;  
    };
    
    ret.setTail = function (type) {
        dirty = !0;
    };
    
    ret.getElement = function() {
        return element;
    };
    
    return ret;
};*/