      // scan page for widgets and instantiate them

      dojo.require("dojo.on");
      dojo.require("dijit.registry");

      dojo.require("dojo.parser");
      // dnd:
      
      dojo.require("dojo.dnd.Source");
      dojo.require("dojo.date.locale");

      // for the Tree
      dojo.require("dojo.data.ItemFileWriteStore");
      dojo.require("dojo.data.ItemFileReadStore");

      dojo.require("dijit.Menu");
      
      dojo.require("dijit.ColorPalette");
      dojo.require("dijit.ProgressBar");
      dojo.require("dijit.TitlePane");
      dojo.require("dijit.Tooltip");
      dojo.require("dijit.Tree");
      dojo.require("dijit.InlineEditBox");
      dojo.require("dijit.Dialog");
      // editor:
      dojo.require("dijit.Editor");

      dojo.require("dijit._tree.dndSource");

      // various Form elemetns
      dojo.require("dijit.form.Form");
      dojo.require("dijit.form.CheckBox");
      dojo.require("dijit.form.Textarea");
      dojo.require("dijit.form.FilteringSelect");
      dojo.require("dijit.form.TextBox");
      dojo.require("dijit.form.DateTextBox");
      dojo.require("dijit.form.TimeTextBox");
      dojo.require("dijit.form.Button");
      dojo.require("dijit.form.NumberSpinner");
      dojo.require("dijit.form.Slider");
      dojo.require("dijit.form.CheckBox");
      dojo.require("dijit.form.MultiSelect");

      // layouts used in page
      dojo.require("dijit.layout.AccordionContainer");
      dojo.require("dijit.layout.ContentPane");
      dojo.require("dijit.layout.TabContainer");
      dojo.require("dijit.layout.BorderContainer");

      // for wipeTo
      dojo.require("dojo.fx");
      dojo.require("dojox.fx");
      
      dojo.require("dojox.form.BusyButton");
      //dojo.require("dojox.form.FileInputAuto");
      dojo.require("dojox.form.Uploader");
      //dojo.require("dojox.form.uploader.FileList");
      dojo.require("dojox.form.TimeSpinner");
      dojo.require("dojox.layout.ContentPane");

      dojo.require("dojox.grid.DataGrid");
      dojo.require("dojox.data.QueryReadStore");



dojo.provide("dijit.form.ValidationTextArea");
dojo.require("dojo.i18n");
dojo.require("dijit.form.TextBox");
dojo.require("dijit.Tooltip");
dojo.requireLocalization("dijit.form", "validate");

/*=====
    dijit.form.ValidationTextBox.__Constraints = function(){
        // locale: String
        //        locale used for validation, picks up value from this widget's lang attribute
        // _flags_: anything
        //        various flags passed to regExpGen function
        this.locale = "";
        this._flags_ = "";
    }
=====*/

dojo.declare(
    "dijit.form.ValidationTextArea",
    dijit.form.TextBox,
    {
        // summary:
        //        Base class for textbox widgets with the ability to validate content of various types and provide user feedback.
        // tags:
        //        protected

        templateString: "<textarea name=${name} ${nameAttrSetting} dojoAttachPoint='focusNode,containerNode,textbox' autocomplete='off'></textarea>",
        baseClass: "dijitTextArea",

        attributeMap: dojo.delegate(dijit.form._FormValueWidget.prototype.attributeMap, {
            rows:"textbox", cols: "textbox"
        }),

        // rows: Number
        //        The number of rows of text.
        rows: "3",

        // rows: Number
        //        The number of characters per line.
        cols: "20",

        // required: Boolean
        //        User is required to enter data into this field.
        required: false,

        // promptMessage: String
        //        If defined, display this hint string immediately on focus to the textbox, if empty.
        //        Think of this like a tooltip that tells the user what to do, not an error message
        //        that tells the user what they've done wrong.
        //
        //        Message disappears when user starts typing.
        promptMessage: "",

        // invalidMessage: String
        //         The message to display if value is invalid.
        invalidMessage: "$_unset_$", // read from the message file if not overridden

        // constraints: dijit.form.ValidationTextBox.__Constraints
        //        user-defined object needed to pass parameters to the validator functions
        constraints: {},

        // regExp: [extension protected] String
        //        regular expression string used to validate the input
        //        Do not specify both regExp and regExpGen
        regExp: "(.|[\r\n])*",

        regExpGen: function(/*dijit.form.ValidationTextBox.__Constraints*/constraints){
            // summary:
            //        Overridable function used to generate regExp when dependent on constraints.
            //        Do not specify both regExp and regExpGen.
            // tags:
            //        extension protected
            return this.regExp; // String
        },

        // state: [readonly] String
        //        Shows current state (ie, validation result) of input (Normal, Warning, or Error)
        state: "",

        // tooltipPosition: String[]
        //        See description of `dijit.Tooltip.defaultPosition` for details on this parameter.
        tooltipPosition: [],

        _setValueAttr: function(){
            // summary:
            //        Hook so attr('value', ...) works.
            this.inherited(arguments);
            this.validate(this._focused);
        },

        validator: function(/*anything*/value, /*dijit.form.ValidationTextBox.__Constraints*/constraints){
            // summary:
            //        Overridable function used to validate the text input against the regular expression.
            // tags:
            //        protected
            return (new RegExp("^(?:" + this.regExpGen(constraints) + ")"+(this.required?"":"?")+"$")).test(value) &&
                (!this.required || !this._isEmpty(value)) &&
                (this._isEmpty(value) || this.parse(value, constraints) !== undefined); // Boolean
        },

        _isValidSubset: function(){
            // summary:
            //        Returns true if the value is either already valid or could be made valid by appending characters.
            //        This is used for validation while the user [may be] still typing.
            return this.textbox.value.search(this._partialre) == 0;
        },

        isValid: function(/*Boolean*/ isFocused){
            // summary:
            //        Tests if value is valid.
            //        Can override with your own routine in a subclass.
            // tags:
            //        protected
            return this.validator(this.textbox.value, this.constraints);
        },

        _isEmpty: function(value){
            // summary:
            //        Checks for whitespace
            return /^\s*$/.test(value); // Boolean
        },

        getErrorMessage: function(/*Boolean*/ isFocused){
            // summary:
            //        Return an error message to show if appropriate
            // tags:
            //        protected
            return this.invalidMessage; // String
        },

        getPromptMessage: function(/*Boolean*/ isFocused){
            // summary:
            //        Return a hint message to show when widget is first focused
            // tags:
            //        protected
            return this.promptMessage; // String
        },

        _maskValidSubsetError: true,
        validate: function(/*Boolean*/ isFocused){
            // summary:
            //        Called by oninit, onblur, and onkeypress.
            // description:
            //        Show missing or invalid messages if appropriate, and highlight textbox field.
            // tags:
            //        protected
            var message = "";
            var isValid = this.disabled || this.isValid(isFocused);
            if(isValid){ this._maskValidSubsetError = true; }
            var isValidSubset = !isValid && isFocused && this._isValidSubset();
            var isEmpty = this._isEmpty(this.textbox.value);
            if(isEmpty){ this._maskValidSubsetError = true; }
            this.state = (isValid || (!this._hasBeenBlurred && isEmpty) || isValidSubset) ? "" : "Error";
            if(this.state == "Error"){ this._maskValidSubsetError = false; }
            this._setStateClass();
            dijit.setWaiState(this.focusNode, "invalid", isValid ? "false" : "true");
            if(isFocused){
                if(isEmpty){
                    message = this.getPromptMessage(true);
                }
                if(!message && (this.state == "Error" || (isValidSubset && !this._maskValidSubsetError))){
                    message = this.getErrorMessage(true);
                }
            }
            this.displayMessage(message);
            return isValid;
        },

        // _message: String
        //        Currently displayed message
        _message: "",

        displayMessage: function(/*String*/ message){
            // summary:
            //        Overridable method to display validation errors/hints.
            //        By default uses a tooltip.
            // tags:
            //        extension
            if(this._message == message){ return; }
            this._message = message;
            dijit.hideTooltip(this.domNode);
            if(message){
                dijit.showTooltip(message, this.domNode, this.tooltipPosition);
            }
        },
        
        // Methods

        _refreshState: function(){
            // Overrides TextBox._refreshState()
            this.validate(this._focused);
            this.inherited(arguments);
        },

        constructor: function(){
            this.constraints = {};
        },

        postMixInProperties: function(){
            // Copy value from srcNodeRef, unless user specified a value explicitly (or there is no srcNodeRef)
            if(!this.value && this.srcNodeRef){
                this.value = this.srcNodeRef.value;
            }
            this.inherited(arguments);
            this.constraints.locale = this.lang;
            this.messages = dojo.i18n.getLocalization("dijit.form", "validate", this.lang);
            if(this.invalidMessage == "$_unset_$"){ this.invalidMessage = this.messages.invalidMessage; }
            var p = this.regExpGen(this.constraints);
            this.regExp = p;
            var partialre = "";
            // parse the regexp and produce a new regexp that matches valid subsets
            // if the regexp is .* then there's no use in matching subsets since everything is valid
            if(p != ".*"){ this.regExp.replace(/\\.|\[\]|\[.*?[^\\]{1}\]|\{.*?\}|\(\?[=:!]|./g,
                function (re){
                    switch(re.charAt(0)){
                        case '{':
                        case '+':
                        case '?':
                        case '*':
                        case '^':
                        case '$':
                        case '|':
                        case '(':
                            partialre += re;
                            break;
                        case ")":
                            partialre += "|$)";
                            break;
                         default:
                            partialre += "(?:"+re+"|$)";
                            break;
                    }
                }
            );}
            try{ // this is needed for now since the above regexp parsing needs more test verification
                "".search(partialre);
            }catch(e){ // should never be here unless the original RE is bad or the parsing is bad
                partialre = this.regExp;
                console.warn('RegExp error in ' + this.declaredClass + ': ' + this.regExp);
            } // should never be here unless the original RE is bad or the parsing is bad
            this._partialre = "^(?:" + partialre + ")$";
        },

        filter: function(/*String*/ value){
            // Override TextBox.filter to deal with newlines... specifically (IIRC) this is for IE which writes newlines
            // as \r\n instead of just \n
            if(value){
                value = value.replace(/\r/g,"");
            }
            return this.inherited(arguments);
        },

        _setDisabledAttr: function(/*Boolean*/ value){
            this.inherited(arguments);    // call FormValueWidget._setDisabledAttr()
            this._refreshState();
        },

        _setRequiredAttr: function(/*Boolean*/ value){
            this.required = value;
            dijit.setWaiState(this.focusNode,"required", value);
            this._refreshState();
        },

        postCreate: function(){
            if(dojo.isIE){ // IE INPUT tag fontFamily has to be set directly using STYLE
                var s = dojo.getComputedStyle(this.focusNode);
                if(s){
                    var ff = s.fontFamily;
                    if(ff){
                        this.focusNode.style.fontFamily = ff;
                    }
                }
            }
            this.inherited(arguments);
            if(dojo.isIE && this.cols){ // attribute selectors is not supported in IE6
                dojo.addClass(this.textbox, "dijitTextAreaCols");
            }
        },

        reset:function(){
            // Overrides dijit.form.TextBox.reset() by also
            // hiding errors about partial matches
            this._maskValidSubsetError = true;
            this.inherited(arguments);
        },

        _onBlur: function(){
            this.displayMessage('');
            this.inherited(arguments);
        },

        _previousValue: "",
        _onInput: function(/*Event?*/ e){
            // Override TextBox._onInput() to enforce maxLength restriction
            if(this.maxLength){
                var maxLength = parseInt(this.maxLength);
                var value = this.textbox.value.replace(/\r/g,'');
                var overflow = value.length - maxLength;
                if(overflow > 0){
                    if(e){ dojo.stopEvent(e); }
                    var textarea = this.textbox;
                    if(textarea.selectionStart){
                        var pos = textarea.selectionStart;
                        var cr = 0;
                        if(dojo.isOpera){
                            cr = (this.textbox.value.substring(0,pos).match(/\r/g) || []).length;
                        }
                        this.textbox.value = value.substring(0,pos-overflow-cr)+value.substring(pos-cr);
                        textarea.setSelectionRange(pos-overflow, pos-overflow);
                    }else if(dojo.doc.selection){ //IE
                        textarea.focus();
                        var range = dojo.doc.selection.createRange();
                        // delete overflow characters
                        range.moveStart("character", -overflow);
                        range.text = '';
                        // show cursor
                        range.select();
                    }
                }
                this._previousValue = this.textbox.value;
            }
            this.inherited(arguments);
        }
    }
);
dojo.require("dijit.form.ValidationTextArea");