/*
 * ToolBar.fx
 *
 * Created on 13/02/2010, 11:37:17 AM
 */

package org.semanticwb.process.modeler;

import javafx.scene.CustomNode;
import javafx.scene.Node;
import javafx.scene.Group;
import javafx.scene.layout.Flow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import applets.commons.JSONObject;
import javafx.stage.Stage;
import applets.commons.WBConnection;
import org.semanticwb.process.modeler.SubMenu;
import java.lang.Exception;
import org.semanticwb.process.modeler.StartEvent;
import org.semanticwb.process.modeler.SequenceFlow;
import org.semanticwb.process.modeler.SubProcess;
import org.semanticwb.process.modeler.ConditionalFlow;
import org.semanticwb.process.modeler.ComplexGateway;
import applets.commons.JSONArray;
import javafx.stage.AppletStageExtension;
import javafx.stage.Alert;
import applets.commons.WBXMLParser;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedOutputStream;
import org.semanticwb.process.modeler.GraphicalElement;
import org.semanticwb.process.modeler.ModelerUtils;
import java.lang.Class;
import java.lang.String;
import org.semanticwb.process.modeler.MessageStartEvent;
import org.semanticwb.process.modeler.TimerStartEvent;
import org.semanticwb.process.modeler.RuleStartEvent;
import org.semanticwb.process.modeler.SignalStartEvent;
import org.semanticwb.process.modeler.MultipleStartEvent;
import org.semanticwb.process.modeler.MessageIntermediateCatchEvent;
import org.semanticwb.process.modeler.TimerIntermediateCatchEvent;
import org.semanticwb.process.modeler.ErrorIntermediateCatchEvent;
import org.semanticwb.process.modeler.MessageIntermediateThrowEvent;
import org.semanticwb.process.modeler.CancelationIntermediateCatchEvent;
import org.semanticwb.process.modeler.RuleIntermediateCatchEvent;
import org.semanticwb.process.modeler.LinkIntermediateCatchEvent;
import org.semanticwb.process.modeler.LinkIntermediateThrowEvent;
import org.semanticwb.process.modeler.SignalIntermediateCatchEvent;
import org.semanticwb.process.modeler.SignalIntermediateThrowEvent;
import org.semanticwb.process.modeler.CompensationIntermediateCatchEvent;
import org.semanticwb.process.modeler.CompensationIntermediateThrowEvent;
import org.semanticwb.process.modeler.MultipleIntermediateCatchEvent;
import org.semanticwb.process.modeler.MultipleIntermediateThrowEvent;
import org.semanticwb.process.modeler.MessageEndEvent;
import org.semanticwb.process.modeler.ErrorEndEvent;
import org.semanticwb.process.modeler.CancelationEndEvent;
import org.semanticwb.process.modeler.SignalEndEvent;
import org.semanticwb.process.modeler.CompensationEndEvent;
import org.semanticwb.process.modeler.MultipleEndEvent;
import org.semanticwb.process.modeler.TerminationEndEvent;

public var counter: Integer;
public var conn:WBConnection = new WBConnection(FX.getArgument(WBConnection.PRM_JSESS).toString(),FX.getArgument(WBConnection.PRM_CGIPATH).toString(),FX.getProperty("javafx.application.codebase"));

/**
 * @author javier.solis
 */

public class ToolBar extends CustomNode
{
    public var modeler:Modeler;
    public var stage:Stage;
    public var x:Number;
    public var y:Number;
    public var w:Number;
    public var h:Number;
    var dx : Number;                        //temporal drag x
    var dy : Number;                        //temporal drag y
    var isApplet:Boolean=FX.getArgument(WBConnection.PRM_CGIPATH).toString()!=null;

    var fileChooser = javax.swing.JFileChooser{};
    var imageFileChooser = javax.swing.JFileChooser{};
    var hidden:Boolean = false;

    def imgDiv: Image = Image {
        url: "{__DIR__}images/barra_division.png"
    }
    def imgSpace: Image = Image {
        url: "{__DIR__}images/barra_espacio.png"
    }
    def imgTitleBar: Image = Image {
        url: "{__DIR__}images/barra_mov.png"
    }
    def imgBottomBar: Image = Image {
        url: "{__DIR__}images/barra_bottom.png"
    }

    def undoMgr: UndoMgr = UndoMgr
    {
       override public function getState () : String {
           return getProcess();
       }
    }

    public function openProcess(): Void
    {
        //fileChooser.setDialogType(javax.swing.JFileChooser.OPEN_DIALOG);
        if (fileChooser.showOpenDialog(null) == javax.swing.JFileChooser.APPROVE_OPTION)
        {
            var file = fileChooser.getSelectedFile();
            //println(file);
            try
            {
                var in=new FileInputStream(file);
                var proc=WBConnection.readInputStream(in);
                //println(proc);
                delete modeler.contents;
                modeler.containerElement=null;
                createProcess(proc);
            }catch(e:Exception){Alert.inform("Error",e.getMessage());}
        }
    }

    public function saveAsImage(): Void
    {
        //fileChooser.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        if (imageFileChooser.showSaveDialog(null) == javax.swing.JFileChooser.APPROVE_OPTION) {
            var file = imageFileChooser.getSelectedFile();
            if(not file.getName().toLowerCase().endsWith("png"))
            {
                file=new File("{file.getPath()}.png");
            }
            //println(file);
            var bufferedImage=modeler.renderToImage(25);
            //println(bufferedImage);
            try
            {
                var out=new FileOutputStream(file);
                def bufferedOutputStream = new BufferedOutputStream(out);
                //println(bufferedOutputStream);
                javax.imageio.ImageIO.write( bufferedImage, "PNG", bufferedOutputStream );
                bufferedOutputStream.close();
                out.close();
                //println("end");
            }catch(e:Exception)
            {
                //println(e.getMessage());
                Alert.inform("Error",e.getMessage());
            }
        }
    }

    public function saveProcess(): Void
    {
        if (fileChooser.showSaveDialog(null) == javax.swing.JFileChooser.APPROVE_OPTION)
        {
            var file = fileChooser.getSelectedFile();
            if(not file.getName().toLowerCase().endsWith("swp"))
            {
                file=new File("{file.getPath()}.swp");
            }

            //println(file);
            var proc=getProcess();
            try
            {
                var out=new FileOutputStream(file);
                out.write(proc.getBytes());
                out.close();
                //var o= new ObjectOutputStream(out);
                //o.writeObject(modeler);
                //o.close();
            }catch(e:Exception){Alert.inform("Error",e.getMessage());}
        }
    }

    public function storeProcess(): Void
    {
        var process=getProcess();

        var comando="<?xml version=\"1.0\" encoding=\"UTF-8\"?><req><cmd>updateModel</cmd><json>{WBXMLParser.encode(process,"UTF8")}</json></req>";
        var data=conn.getData(comando);
        AppletStageExtension.eval("parent.reloadTreeNodeByURI('{conn.getUri()}')");
        if(data.indexOf("OK")>0)
        {
            Alert.inform("SemanticWebBuilder",##"msgSent");
            loadProcess();
        }else
        {
            Alert.inform("Error",data);
        }
    }

    public function loadProcess(): Void
    {
        try
        {
            var comando="<?xml version=\"1.0\" encoding=\"UTF-8\"?><req><cmd>getProcessJSON</cmd></req>";
            var json=conn.getData(comando);
            //println("json:{json}");
            delete modeler.contents;
            modeler.containerElement=null;
            createProcess(json);
        }catch(e:Exception){println(e);}

    }

    /**
    * Serialyze the process to JSON
    */
    public function getProcess(): String
    {
        var obj:JSONObject =new JSONObject();
        obj.put("uri","test");
        var nodes:JSONArray =new JSONArray();
        obj.putOpt("nodes",nodes);
        for(node in modeler.contents)
        {
            var ele=getJSONObject(node);
            nodes.put(ele);

            if(node instanceof Pool)
            {
                var pool=node as Pool;
                for(lane in pool.lanes)
                {
                    nodes.put(getJSONObject(lane));
                }
            }
        }
        return obj.toString();
    }

    function getClassName(cls:Class) : String
    {
        var name=cls.getSimpleName();
        var i=name.indexOf("$");
        if(i>0)     //por lo menos un caracter
        {
            name=name.substring(0,i);
        }
        //println("name:{name}");
        return name;
    }


    function getJSONObject(node:Node):JSONObject
    {
        var ele:JSONObject=new JSONObject();
        if(node instanceof GraphicalElement)
        {
           var ge=node as GraphicalElement;
           //println("{ge.getClass().getName()} {ge.getClass().getCanonicalName()} {ge.getClass().getPackage()} {ge.getClass().getSimpleName()}");
           ele.put("class",getClassName(ge.getClass()));
           ele.put("container",ge.getContainer().uri);
           ele.put("parent",ge.getGraphParent().uri);
           ele.put("title",ge.title);
           //ele.put("type",ge.type);
           ele.put("uri",ge.uri);
           ele.put("x",ge.x);
           ele.put("y",ge.y);
           ele.put("w",ge.w);
           ele.put("h",ge.h);
           ele.put("isMultiInstance",ge.isMultiInstance);
           ele.put("isLoop", ge.isLoop);
           ele.put("isForCompensation", ge.isForCompensation);
        }

        if(node instanceof ConnectionObject)
        {
           var ge=node as ConnectionObject;
           ele.put("class",getClassName(ge.getClass()));
           ele.put("uri",ge.uri);
           ele.put("title",ge.title);
           ele.put("start",ge.ini.uri);
           ele.put("end",ge.end.uri);
           if(node instanceof ConditionalFlow)
           {
               //var con=node as ConditionalFlow;
               ele.put("action", ge.action);
           }
        }
        return ele;
    }


    /**
    * Increment the internal counter for new uris
    */
    function validateUri(uri:String):String
    {
        if(uri.startsWith("new:"))
        {
            var c=Integer.parseInt(uri.substring(uri.lastIndexOf(":")+1));
            if(c>counter)counter=c+1;
        }
        return uri;
    }

    /**
    * Create a process from a JSON
    */
    public function createProcess(json:String): Void
    {
        //println("Arguments:{FX.getArgument}");

        var pkg:String="org.semanticwb.process.modeler";

        var jsobj=new JSONObject(json);
        var jsarr = jsobj.getJSONArray("nodes");
        var i=0;
        //GraphicElements
        while(i<jsarr.length())
        {
            //generic
            var js = jsarr.getJSONObject(i);
            var cls:String="{pkg}.{js.getString("class")}";
            var uri:String=validateUri(js.getString("uri"));

            var clss=getClass().forName(cls);
            var node=clss.newInstance() as Node;
            var ge:GraphicalElement=null;
            if(node instanceof GraphicalElement)
            {
                ge=node as GraphicalElement;
            }

            if(ge!=null and not (ge instanceof Lane))
            {
                var title=js.getString("title");
                var isLoop=js.optBoolean("isLoop", false);
                var isMultiInstance=js.optBoolean("isMultiInstance", false);
                var isForCompensation=js.optBoolean("isForCompensation", false);
                //var type=js.getString("type");
                var x=js.getInt("x");
                var y=js.getInt("y");
                var w=js.getInt("w");
                var h=js.getInt("h");

                ge.modeler=modeler;
                ge.uri=uri;
                ge.isLoop = isLoop;
                ge.isMultiInstance = isMultiInstance;
                ge.isForCompensation = isForCompensation;
                //println("uri:{ge.uri}");
                ge.title=title;
                //ge.setType(type);
                ge.x=x;
                ge.y=y;
                if(w>0)ge.w=w;
                if(h>0)ge.h=h;
                if(ge instanceof Pool)
                {
                    modeler.addFirst(ge);
                }else
                {
                    modeler.add(ge);
                }
                //println("jsobj:{js.toString()}, i: {i}");
            }
            i++;
        }


        //Lanes
        i=0;
        while(i<jsarr.length())
        {
            //generic
            var js = jsarr.getJSONObject(i);
            var cls:String="{pkg}.{js.getString("class")}";
            var uri:String=validateUri(js.getString("uri"));

            var clss=getClass().forName(cls);
            var node=clss.newInstance() as Node;

            if(node instanceof Lane)
            {
                var parent=js.getString("parent");
                var title=js.getString("title");
                //var type=js.getString("type");
                var h=js.getInt("h");
                var p=modeler.getGraphElementByURI(parent);
                if(p instanceof Pool)
                {
                    var pool=p as Pool;
                    var lane=pool.addLane();
                    lane.title=title;
                    //lane.type=type;
                    lane.h=h;
                    lane.uri=uri;
                }
            }
            i++;
        }


        //ConnectionObjects
        i=0;
        while(i<jsarr.length())
        {
            //generic
            var js = jsarr.getJSONObject(i);
            var cls:String="{pkg}.{js.getString("class")}";
            var uri:String=validateUri(js.getString("uri"));

            var clss=getClass().forName(cls);
            var node=clss.newInstance() as Node;

            //Parents
            var ge:GraphicalElement=null;
            if(node instanceof GraphicalElement)
            {
                ge=modeler.getGraphElementByURI(uri);
            }

            if(ge!=null)
            {
                var parent=js.getString("parent");
                ge.setGraphParent(modeler.getGraphElementByURI(parent));
                var container=js.getString("container");
                ge.setContainer(modeler.getGraphElementByURI(container));
                //println("{ge} parent:{ge.getGraphParent()}");
            }

            //Connections
            var co:ConnectionObject=null;
            if(node instanceof ConnectionObject)
            {
                co=node as ConnectionObject;
            }

            if(co!=null)
            {
                //ConnectionObjects
                var start=js.getString("start");
                var end=js.getString("end");
                var title=js.getString("title");

                co.modeler=modeler;
                co.uri=uri;
                co.title=title;
                co.ini=modeler.getGraphElementByURI(start);
                co.end=modeler.getGraphElementByURI(end);
                modeler.add(co);
                //println("jsobj:{js.toString()}, i: {i}");
            }
            i++;
        }
    }

    public override function create(): Node
    {
        var filter = FileFilter{};
        fileChooser.setFileFilter(filter);
        var imgFilter = ImageFileFilter{};
        imageFileChooser.setFileFilter(imgFilter);

        if(isApplet)loadProcess();

        var file=SubMenu
        {
            modeler: modeler
            toolBar:this
            text: ##"file"//ModelerUtils.getLocalizedString("file")
            image: "images/file1.png"
            imageOver: "images/file2.png"
            imageClicked: "images/file3.png"
            visible: bind not hidden
            buttons: [
                ImgButton {
                    text: ##"new"//ModelerUtils.getLocalizedString("new")
                    image: "images/file_nuevo1.png"
                    imageOver: "images/file_nuevo2.png"
                    action: function():Void
                    {
                        var tit = ##"alertMsg";
                        var msg = ##"msgSaveAlert";
                        if(Alert.confirm(tit, msg)) {
                            ModelerUtils.clickedNode=null;
                            ModelerUtils.setResizeNode(null);
                            modeler.containerElement=null;
                            modeler.disablePannable=false;
                            delete modeler.contents;
                        }
                    }
                },
                ImgButton {
                    text: ##"open"//ModelerUtils.getLocalizedString("open")
                    image: "images/file_abrir1.png"
                    imageOver: "images/file_abrir2.png"
                    action: function():Void
                    {
                        ModelerUtils.clickedNode=null;
                        ModelerUtils.setResizeNode(null);
                        modeler.containerElement=null;
                        modeler.disablePannable=false;
                        openProcess();
                    }
                },
                ImgButton {
                    text: ##"save"//ModelerUtils.getLocalizedString("save")
                    image: "images/file_guardar1.png"
                    imageOver: "images/file_guardar2.png"
                    action: function():Void
                    {
                        ModelerUtils.clickedNode=null;
                        modeler.disablePannable=false;
                        if(isApplet)
                        {
                            storeProcess();
                        }else
                        {
                            saveProcess();
                        }
                    }
                },
                ImgButton {
                    text: ##"export"//ModelerUtils.getLocalizedString("export")
                    image: "images/file_saveasimage1.png"
                    imageOver: "images/file_saveasimage2.png"
                    action: function():Void
                    {
                        ModelerUtils.clickedNode=null;
                        modeler.disablePannable=false;
                        saveAsImage();
                    }
                },
//                ImgButton {
//                    text: ##"exportxpdl"//ModelerUtils.getLocalizedString("export")
//                    image: "images/file_saveasxpdl1.png"
//                    imageOver: "images/file_saveasxpdl2.png"
//                    action: function():Void
//                    {
//                        ModelerUtils.clickedNode=null;
//                        modeler.disablePannable=false;
//                        //getXPDL();
//                    }
//                },
                ImgButton {
                    text: ##"print"//ModelerUtils.getLocalizedString("print")
                    image: "images/file_print1.png"
                    imageOver: "images/file_print2.png"
                    action: function():Void
                    {
                        var print=PrintUtil{};
                        var aux=modeler.containerElement;
                        modeler.containerElement=null;
                        var arr=[modeler.renderToImage(1)];
                        for(node in modeler.contents)
                        {
                            if(node instanceof GraphicalElement)
                            {
                                var ge=node as GraphicalElement;
                                if(ge.containerable)
                                {
                                    modeler.containerElement=ge;
                                    insert modeler.renderToImage(1) into arr;
                                }
                            }
                        }
                        modeler.containerElement=aux;
                        //print.print(arr);
                        //TODO:
                    }
                },
                ImgButton {
                    text: ##"about"//ModelerUtils.getLocalizedString("about")
                    image: "images/file_about1.png"
                    imageOver: "images/file_about2.png"
                    action: function():Void
                    {
                        ModelerUtils.clickedNode=null;
                        modeler.disablePannable=false;
                        ModelerUtils.splash.showDialog(modeler.width/2,modeler.height/2);
                    }
                },
            ]
        };

        var task=SubMenu
        {
            modeler: modeler
            toolBar:this
            text: ##"task"//ModelerUtils.getLocalizedString("task")
            image: "images/task_1.png"
            imageOver: "images/task_2.png"
            imageClicked: "images/task_3.png"
            visible: bind not hidden
            buttons: [
                ImgButton {
                    text: ##"abstractTask"//ModelerUtils.getLocalizedString("abstractTask")
                    image: "images/task_normal1.png"
                    imageOver: "images/task_normal2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=Task
                        {
                            modeler:modeler
                            title: ##"abstractTask"//ModelerUtils.getLocalizedString("abstractTask")
                            uri:"new:task:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"userTask"//ModelerUtils.getLocalizedString("userTask")
                    image: "images/task_usr1.png"
                    imageOver: "images/task_usr2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=UserTask
                        {
                            modeler:modeler
                            title: ##"userTask"//ModelerUtils.getLocalizedString("userTask")
                            uri:"new:usertask:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"serviceTask"//ModelerUtils.getLocalizedString("serviceTask")
                    image: "images/task_servicio1.png"
                    imageOver: "images/task_servicio2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=ServiceTask
                        {
                            modeler:modeler
                            title: ##"serviceTask"//ModelerUtils.getLocalizedString("serviceTask")
                            uri:"new:servicetask:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"scriptTask"//ModelerUtils.getLocalizedString("scriptTask")
                    image: "images/task_script1.png"
                    imageOver: "images/task_script2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=ScriptTask
                        {
                            modeler:modeler
                            title: ##"scriptTask"//ModelerUtils.getLocalizedString("scriptTask")
                            uri:"new:scripttask:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"manualTask"//ModelerUtils.getLocalizedString("manualTask")
                    image: "images/task_manual1.png"
                    imageOver: "images/task_manual2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=ManualTask
                        {
                            modeler:modeler
                            title: ##"manualTask"//ModelerUtils.getLocalizedString("manualTask")
                            uri:"new:manualtask:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"sendTask"//ModelerUtils.getLocalizedString("sendTask")
                    image: "images/task_envio1.png"
                    imageOver: "images/task_envio2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=SendTask
                        {
                            modeler:modeler
                            title: ##"sendTask"//ModelerUtils.getLocalizedString("sendTask")
                            uri:"new:sendtask:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"receiveTask"//ModelerUtils.getLocalizedString("receiveTask")
                    image: "images/task_recive1.png"
                    imageOver: "images/task_recive2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=ReceiveTask
                        {
                            modeler:modeler
                            title: ##"receiveTask"//ModelerUtils.getLocalizedString("receiveTask")
                            uri:"new:receivetask:{counter++}"
                        }
                    }
                },
            ]
        };

        var subtask=SubMenu
        {
            modeler: modeler
            toolBar:this
            text: ##"subTask"//ModelerUtils.getLocalizedString("subTask")
            image: "images/subtask_1.png"
            imageOver: "images/subtask_2.png"
            imageClicked: "images/subtask_3.png"
            visible: bind not hidden
            buttons: [
                ImgButton {
                    text: ##"subProcess"//ModelerUtils.getLocalizedString("subProcess")
                    image: "images/subtask_colapsado1.png"
                    imageOver: "images/subtask_colapsado2.png"
                    action: function():Void {
                        modeler.disablePannable=true;
                        modeler.tempNode=SubProcess
                        {
                            modeler:modeler
                            title: ##"subProcess"//ModelerUtils.getLocalizedString("subProcess")
                            uri:"new:subprocess:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"adhocSubProcess"//ModelerUtils.getLocalizedString("adhocSubProcess")
                    image: "images/subtask_adhoc+1.png"
                    imageOver: "images/subtask_adhoc+2.png"
                    action: function():Void {
                        modeler.disablePannable=true;
                        modeler.tempNode=AdhocSubProcess
                        {
                            modeler:modeler
                            title: ##"adhocSubProcess"//ModelerUtils.getLocalizedString("adhocSubProcess")
                            uri:"new:adhocsubprocess:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"eventSubProcess"//ModelerUtils.getLocalizedString("eventSubProcess")
                    image: "images/subtask_evento1.png"
                    imageOver: "images/subtask_evento2.png"
                    action: function():Void {
                        modeler.disablePannable=true;
                        modeler.tempNode=EventSubProcess
                        {
                            modeler:modeler
                            title: ##"eventSubProcess"//ModelerUtils.getLocalizedString("eventSubProcess")
                            uri:"new:eventsubprocess:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"transaction"//ModelerUtils.getLocalizedString("transaction")
                    image: "images/subtask_transaccion1.png"
                    imageOver: "images/subtask_transaccion2.png"
                    action: function():Void {
                        modeler.disablePannable=true;
                        modeler.tempNode=TransactionSubProcess
                        {
                            modeler:modeler
                            title: ##"transaction"//ModelerUtils.getLocalizedString("transaction")
                            uri:"new:transactionsubprocess:{counter++}"
                        }
                    }
                },
            ]
        };

        var startEvent=SubMenu
        {
            modeler: modeler
            toolBar:this
            text: ##"startEvents"//ModelerUtils.getLocalizedString("startEvents")
            image: "images/start_1.png"
            imageOver: "images/start_2.png"
            imageClicked: "images/start_3.png"
            visible: bind not hidden
            buttons: [
                ImgButton {
                    text: ##"normalStart"//ModelerUtils.getLocalizedString("normalStart")
                    image: "images/start_normal1.png"
                    imageOver: "images/start_normal2.png"
                    action: function():Void {
                        modeler.disablePannable=true;
                        modeler.tempNode=StartEvent
                        {
                            modeler:modeler
                            title: ##"normalStart"//ModelerUtils.getLocalizedString("normalStart")
                            uri:"new:startevent:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"messageStart"//ModelerUtils.getLocalizedString("messageStart")
                    image: "images/start_msj1.png"
                    imageOver: "images/start_msj2.png"
                    action: function():Void {
                        modeler.disablePannable=true;
                        modeler.tempNode=MessageStartEvent
                        {
                            modeler:modeler
                            title: ##"messageStart"//ModelerUtils.getLocalizedString("messageStart")
                            uri:"new:startevent:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"timerStart"//ModelerUtils.getLocalizedString("timerStart")
                    image: "images/start_tmp1.png"
                    imageOver: "images/start_tmp2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=TimerStartEvent
                        {
                            modeler:modeler
                            title: ##"timerStart"//ModelerUtils.getLocalizedString("timerStart")
                            uri:"new:startevent:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"ruleStart"//ModelerUtils.getLocalizedString("ruleStart")
                    image: "images/start_cond1.png"
                    imageOver: "images/start_cond2.png"
                    action: function():Void {
                        modeler.disablePannable=true;
                        modeler.tempNode=RuleStartEvent
                        {
                            modeler:modeler
                            title: ##"ruleStart"//ModelerUtils.getLocalizedString("ruleStart")
                            uri:"new:startevent:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"signalStart"//ModelerUtils.getLocalizedString("signalStart")
                    image: "images/start_senal1.png"
                    imageOver: "images/start_senal2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=SignalStartEvent
                        {
                            modeler:modeler
                            title: ##"signalStart"//ModelerUtils.getLocalizedString("signalStart")
                            uri:"new:startevent:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"multipleStart"//ModelerUtils.getLocalizedString("multipleStart")
                    image: "images/start_multi1.png"
                    imageOver: "images/start_multi2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=MultipleStartEvent
                        {
                            modeler:modeler
                            title: ##"multipleStart"//ModelerUtils.getLocalizedString("multipleStart")
                            uri:"new:startevent:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"parallelStart"//ModelerUtils.getLocalizedString("parallelStart")
                    image: "images/start_paralelo1.png"
                    imageOver: "images/start_paralelo2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=ParallelStartEvent
                        {
                            modeler:modeler
                            title: ##"parallelStart"//ModelerUtils.getLocalizedString("parallelStart")
                            uri:"new:startevent:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"scalationStart"//ModelerUtils.getLocalizedString("scalationStart")
                    image: "images/start_escala1.png"
                    imageOver: "images/start_escala2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=ScalationStartEvent
                        {
                            modeler:modeler
                            title: ##"scalationStart"//ModelerUtils.getLocalizedString("scalationStart")
                            uri:"new:startevent:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"errorStart"//ModelerUtils.getLocalizedString("errorStart")
                    image: "images/start_error1.png"
                    imageOver: "images/start_error2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=ErrorStartEvent
                        {
                            modeler:modeler
                            title: ##"errorStart"//ModelerUtils.getLocalizedString("errorStart")
                            uri:"new:startevent:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"compensationStart"//ModelerUtils.getLocalizedString("compensationStart")
                    image: "images/start_compensa1.png"
                    imageOver: "images/start_compensa2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=CompensationStartEvent
                        {
                            modeler:modeler
                            title: ##"compensationStart"//ModelerUtils.getLocalizedString("compensationStart")
                            uri:"new:startevent:{counter++}"
                        }
                    }
                }
            ]
        };

        var interEvent=SubMenu
        {
            modeler: modeler
            toolBar:this
            text: ##"interEvents"//ModelerUtils.getLocalizedString("interEvents")
            image:"images/inter_1.png"
            imageOver:"images/inter_2.png"
            imageClicked: "images/inter_3.png"
            visible: bind not hidden
            buttons: [
//                ImgButton {
//                    text: ModelerUtils.getLocalizedString("normalInter")
//                    image: "images/inter_normal1.png"
//                    imageOver: "images/inter_normal2.png"
//                    action: function():Void {
//                        modeler.disablePannable=true;
//                        modeler.tempNode=IntermediateCatchEvent
//                        {
//                            modeler:modeler
//                            title: ModelerUtils.getLocalizedString("normalInter")
//                            uri:"new:interevent:{counter++}"
//                            //type: Event.RULE;
//                        }
//                    }
//                },
                ImgButton {
                    text: ##"messageInterCatch"//ModelerUtils.getLocalizedString("messageInterCatch")
                    image: "images/inter_msj_b_1.png"
                    imageOver: "images/inter_msj_b_2.png"
                    action: function():Void {
                        modeler.disablePannable=true;
                        modeler.tempNode=MessageIntermediateCatchEvent
                        {
                            modeler:modeler
                            title: ##"messageInterCatch"//ModelerUtils.getLocalizedString("messageInterCatch")
                            uri:"new:interevent:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"messageInterThrow"//ModelerUtils.getLocalizedString("messageInterThrow")
                    image: "images/inter_msj_n_1.png"
                    imageOver: "images/inter_msj_n_2.png"
                    action: function():Void {
                        modeler.disablePannable=true;
                        modeler.tempNode=MessageIntermediateThrowEvent
                        {
                            modeler:modeler
                            title: ##"messageInterThrow"//ModelerUtils.getLocalizedString("messageInterThrow")
                            uri:"new:interevent:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"timerInter"//ModelerUtils.getLocalizedString("timerInter")
                    image: "images/inter_tmp1.png"
                    imageOver: "images/inter_tmp2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=TimerIntermediateCatchEvent
                        {
                            modeler:modeler
                            title: ##"timerInter"//ModelerUtils.getLocalizedString("timerInter")
                            uri:"new:interevent:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"errorInter"//ModelerUtils.getLocalizedString("errorInter")
                    image: "images/inter_error1.png"
                    imageOver: "images/inter_error2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=ErrorIntermediateCatchEvent
                        {
                            modeler:modeler
                            title: ##"errorInter"//ModelerUtils.getLocalizedString("errorInter")
                            uri:"new:interevent:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"cancelInter"//ModelerUtils.getLocalizedString("cancelInter")
                    image: "images/inter_cancel_1.png"
                    imageOver: "images/inter_cancel_2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=CancelationIntermediateCatchEvent
                        {
                            modeler:modeler
                            uri:"new:interevent:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"compensationInterCatch"//ModelerUtils.getLocalizedString("compensationInterCatch")
                    image: "images/inter_compensa_b_1.png"
                    imageOver: "images/inter_compensa_b_2.png"
                    action: function():Void {
                        modeler.disablePannable=true;
                        modeler.tempNode=CompensationIntermediateCatchEvent
                        {
                            modeler:modeler
                            title: ##"compensationInterCatch"//ModelerUtils.getLocalizedString("compensationInterCatch")
                            uri:"new:interevent:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"compensationInterThrow"//ModelerUtils.getLocalizedString("compensationInterThrow")
                    image: "images/inter_compensa_n_1.png"
                    imageOver: "images/inter_compensa_n_2.png"
                    action: function():Void {
                        modeler.disablePannable=true;
                        modeler.tempNode=CompensationIntermediateThrowEvent
                        {
                            modeler:modeler
                            title: ##"compensationInterThrow"//ModelerUtils.getLocalizedString("compensationInterThrow")
                            uri:"new:interevent:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"ruleInter"//ModelerUtils.getLocalizedString("ruleInter")
                    image: "images/inter_cond1.png"
                    imageOver: "images/inter_cond2.png"
                    action: function():Void {
                        modeler.disablePannable=true;
                        modeler.tempNode=RuleIntermediateCatchEvent
                        {
                            modeler:modeler
                            title: ##"ruleInter"//ModelerUtils.getLocalizedString("ruleInter")
                            uri:"new:interevent:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"linkInterCatch"//ModelerUtils.getLocalizedString("linkInterCatch")
                    image: "images/inter_enlace_b_1.png"
                    imageOver: "images/inter_enlace_b_2.png"
                    action: function():Void {
                        modeler.disablePannable=true;
                        modeler.tempNode=LinkIntermediateCatchEvent
                        {
                            modeler:modeler
                            title: ##"linkInterCatch"//ModelerUtils.getLocalizedString("linkInterCatch")
                            uri:"new:interevent:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"linkInterThrow"//ModelerUtils.getLocalizedString("linkInterThrow")
                    image: "images/inter_enlace_n_1.png"
                    imageOver: "images/inter_enlace_n_2.png"
                    action: function():Void {
                        modeler.disablePannable=true;
                        modeler.tempNode=LinkIntermediateThrowEvent
                        {
                            modeler:modeler
                            title: ##"linkInterThrow"//ModelerUtils.getLocalizedString("linkInterThrow")
                            uri:"new:interevent:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"signalInterCatch"//ModelerUtils.getLocalizedString("signalInterCatch")
                    image: "images/inter_senal_b_1.png"
                    imageOver: "images/inter_senal_b_2.png"
                    action: function():Void {
                        modeler.disablePannable=true;
                        modeler.tempNode=SignalIntermediateCatchEvent
                        {
                            modeler:modeler
                            title: ##"signalInterCatch"//ModelerUtils.getLocalizedString("signalInterCatch")
                            uri:"new:interevent:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"signalInterThrow"//ModelerUtils.getLocalizedString("signalInterThrow")
                    image: "images/inter_senal_n_1.png"
                    imageOver: "images/inter_senal_n_2.png"
                    action: function():Void {
                        modeler.disablePannable=true;
                        modeler.tempNode=SignalIntermediateThrowEvent
                        {
                            modeler:modeler
                            title: ##"signalInterThrow"//ModelerUtils.getLocalizedString("signalInterThrow")
                            uri:"new:interevent:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"multInterCatch"//ModelerUtils.getLocalizedString("multInterCatch")
                    image: "images/inter_multi_b_1.png"
                    imageOver: "images/inter_multi_b_2.png"
                    action: function():Void {
                        modeler.disablePannable=true;
                        modeler.tempNode=MultipleIntermediateCatchEvent
                        {
                            modeler:modeler
                            title: ##"multInterCatch"//ModelerUtils.getLocalizedString("multInterCatch")
                            uri:"new:interevent:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"multInterThrow"//ModelerUtils.getLocalizedString("multInterThrow")
                    image: "images/inter_multi_n_1.png"
                    imageOver: "images/inter_multi_n_2.png"
                    action: function():Void {
                        modeler.disablePannable=true;
                        modeler.tempNode=MultipleIntermediateThrowEvent
                        {
                            modeler:modeler
                            title: ##"multInterThrow"//ModelerUtils.getLocalizedString("multInterThrow")
                            uri:"new:interevent:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"scalInterCatch"//ModelerUtils.getLocalizedString("scalInterCatch")
                    image: "images/inter_escala_b_1.png"
                    imageOver: "images/inter_escala_b_2.png"
                    action: function():Void {
                        modeler.disablePannable=true;
                        modeler.tempNode=ScalationIntermediateCatchEvent
                        {
                            modeler:modeler
                            title: ##"scalInterCatch"//ModelerUtils.getLocalizedString("scalInterCatch")
                            uri:"new:interevent:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"scalInterThrow"//ModelerUtils.getLocalizedString("scalInterThrow")
                    image: "images/inter_escala_n_1.png"
                    imageOver: "images/inter_escala_n_2.png"
                    action: function():Void {
                        modeler.disablePannable=true;
                        modeler.tempNode=ScalationIntermediateThrowEvent
                        {
                            modeler:modeler
                            title: ##"scalInterThrow"//ModelerUtils.getLocalizedString("scalInterThrow")
                            uri:"new:interevent:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"parallelInter"//ModelerUtils.getLocalizedString("parallelInter")
                    image: "images/inter_paralelo1.png"
                    imageOver: "images/inter_paralelo2.png"
                    action: function():Void {
                        modeler.disablePannable=true;
                        modeler.tempNode=ParallelIntermediateCatchEvent
                        {
                            modeler:modeler
                            title: ##"parallelInter"//ModelerUtils.getLocalizedString("parallelInter")
                            uri:"new:interevent:{counter++}"
                        }
                    }
                }
            ]
        };

        var endEvent=SubMenu
        {
            modeler: modeler
            toolBar:this
            text: ##"endEvents"//ModelerUtils.getLocalizedString("endEvents")
            image: "images/end_1.png"
            imageOver: "images/end_2.png"
            imageClicked: "images/end_3.png"
            visible: bind not hidden
            buttons: [
                ImgButton {
                    text: ##"normalEnd"//ModelerUtils.getLocalizedString("normalEnd")
                    image: "images/end_normal1.png"
                    imageOver: "images/end_normal2.png"
                    action: function():Void {
                        modeler.disablePannable=true;
                        modeler.tempNode=EndEvent
                        {
                            modeler:modeler
                            title: ##"normalEnd"//ModelerUtils.getLocalizedString("normalEnd")
                            uri:"new:endevent:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"messageEnd"//ModelerUtils.getLocalizedString("messageEnd")
                    image: "images/end_msj1.png"
                    imageOver: "images/end_msj2.png"
                    action: function():Void {
                        modeler.disablePannable=true;
                        modeler.tempNode=MessageEndEvent
                        {
                            modeler:modeler
                            title: ##"messageEnd"//ModelerUtils.getLocalizedString("messageEnd")
                            uri:"new:endevent:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"errorEnd"//ModelerUtils.getLocalizedString("errorEnd")
                    image: "images/end_error1.png"
                    imageOver: "images/end_error2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=ErrorEndEvent
                        {
                            modeler:modeler
                            title: ##"errorEnd"//ModelerUtils.getLocalizedString("errorEnd")
                            uri:"new:endevent:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"cancelEnd"//ModelerUtils.getLocalizedString("cancelEnd")
                    image: "images/end_cancel1.png"
                    imageOver: "images/end_cancel2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=CancelationEndEvent
                        {
                            modeler:modeler
                            title: ##"cancelEnd"//ModelerUtils.getLocalizedString("cancelEnd")
                            uri:"new:endevent:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"compensationEnd"//ModelerUtils.getLocalizedString("compensationEnd")
                    image: "images/end_compensa1.png"
                    imageOver: "images/end_compensa2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=CompensationEndEvent
                        {
                            modeler:modeler
                            title: ##"compensationEnd"//ModelerUtils.getLocalizedString("compensationEnd")
                            uri:"new:endevent:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"signalEnd"//ModelerUtils.getLocalizedString("signalEnd")
                    image: "images/end_senal1.png"
                    imageOver: "images/end_senal2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=SignalEndEvent
                        {
                            modeler:modeler
                            title: ##"signalEnd"//ModelerUtils.getLocalizedString("signalEnd")
                            uri:"new:endevent:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"multipleEnd"//ModelerUtils.getLocalizedString("multipleEnd")
                    image: "images/end_multi1.png"
                    imageOver: "images/end_multi2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=MultipleEndEvent
                        {
                            modeler:modeler
                            title: ##"multipleEnd"//ModelerUtils.getLocalizedString("multipleEnd")
                            uri:"new:endevent:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"scalationEnd"//ModelerUtils.getLocalizedString("scalationEnd")
                    image: "images/end_escala1.png"
                    imageOver: "images/end_escala2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=ScalationEndEvent
                        {
                            modeler:modeler
                            title: ##"scalationEnd"//ModelerUtils.getLocalizedString("scalationEnd")
                            uri:"new:endevent:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"terminateEnd"//ModelerUtils.getLocalizedString("terminateEnd")
                    image: "images/end_termina1.png"
                    imageOver: "images/end_termina2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=TerminationEndEvent
                        {
                            modeler:modeler
                            title: ##"terminateEnd"//ModelerUtils.getLocalizedString("terminateEnd")
                            uri:"new:endevent:{counter++}"
                        }
                    }
                }
            ]
        };

        var gateWay=SubMenu
        {
            modeler: modeler
            toolBar:this
            text: ##"gateways"//ModelerUtils.getLocalizedString("gateways")
            image: "images/if_1.png"
            imageOver: "images/if_2.png"
            imageClicked: "images/if_3.png"
            visible: bind not hidden
            buttons: [
//                ImgButton {
//                    text:"Gateway"
//                    image: "images/gate_normal1.png"
//                    imageOver: "images/gate_normal2.png"
//                    action: function():Void
//                    {
//                        modeler.disablePannable=true;
//                        modeler.tempNode=Gateway
//                        {
//                            modeler:modeler
//                            title:"Gateway"
//                            uri:"new:gateway:{counter++}"
//                        }
//                    }
//                },
                ImgButton {
                    text: ##"xorGateway"//ModelerUtils.getLocalizedString("xorGateway")
                    image: "images/gate_datos1.png"
                    imageOver: "images/gate_datos2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=ExclusiveGateway
                        {
                            modeler:modeler
                            title: ##"xorGateway"//ModelerUtils.getLocalizedString("xorGateway")
                            uri:"new:exclusivegateway:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"orGateway"//ModelerUtils.getLocalizedString("orGateway")
                    image: "images/gate_inclusiva_1.png"
                    imageOver: "images/gate_inclusiva_2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=InclusiveGateway
                        {
                            modeler:modeler
                            title: ##"orGateway"//ModelerUtils.getLocalizedString("orGateway")
                            uri:"new:inclusivegateway:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"xorGatewayStart"//ModelerUtils.getLocalizedString("xorGatewayStart")
                    image: "images/gate_eventos_str_1.png"
                    imageOver: "images/gate_eventos_str_2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=ExclusiveStartEventGateway
                        {
                            modeler:modeler
                            title: ##"xorGatewayStart"//ModelerUtils.getLocalizedString("xorGatewayStart")
                            uri:"new:exclusivestarteventgateway:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"evtXorGateway"//ModelerUtils.getLocalizedString("evtXorGateway");
                    image: "images/gate_eventos_int_1.png"
                    imageOver: "images/gate_eventos_int_2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=ExclusiveIntermediateEventGateway
                        {
                            modeler:modeler
                            title: ##"evtXorGateway"//ModelerUtils.getLocalizedString("evtXorGateway")
                            uri:"new:exclusiveintermediateeventgateway:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"parallelGateway"//ModelerUtils.getLocalizedString("parallelGateway")
                    image: "images/gate_paralela_n_1.png"
                    imageOver: "images/gate_paralela_n_2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=ParallelGateway
                        {
                            modeler:modeler
                            title: ##"parallelGateway"//ModelerUtils.getLocalizedString("parallelGateway")
                            uri:"new:parallelgateway:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"parallelGatewayStart"//ModelerUtils.getLocalizedString("parallelGatewayStart")
                    image: "images/gate_paralela_b_1.png"
                    imageOver: "images/gate_paralela_b_2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=ParallelStartEventGateway
                        {
                            modeler:modeler
                            title: ##"parallelGatewayStart"//ModelerUtils.getLocalizedString("parallelGatewayStart")
                            uri:"new:parallelstarteventgateway:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"complexGateway"//ModelerUtils.getLocalizedString("complexGateway")
                    image: "images/gate_compleja_1.png"
                    imageOver: "images/gate_compleja_2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=ComplexGateway
                        {
                            modeler:modeler
                            title: ##"complexGateway"//ModelerUtils.getLocalizedString("complexGateway")
                            uri:"new:complexgateway:{counter++}"
                        }
                    }
                },
            ]
        }

        var sequence=SubMenu
        {
            modeler: modeler
            toolBar:this
            text: ##"connObjects"//ModelerUtils.getLocalizedString("connObjects")
            image:"images/flow_1.png"
            imageOver:"images/flow_2.png"
            imageClicked: "images/flow_3.png"
            visible: bind not hidden
            buttons: [
                ImgButton {
                    text: ##"sequenceFlow"//ModelerUtils.getLocalizedString("sequenceFlow")
                    image: "images/flow_normal1.png"
                    imageOver: "images/flow_normal2.png"
                    action: function():Void {
                        modeler.disablePannable=true;
                        modeler.tempNode=SequenceFlow
                        {
                            modeler:modeler
                            uri:"new:sequenceflow:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"condFlow"//ModelerUtils.getLocalizedString("condFlow")
                    image: "images/flow_condicion1.png"
                    imageOver: "images/flow_condicion2.png"
                    action: function():Void {
                        modeler.disablePannable=true;
                        modeler.tempNode=ConditionalFlow
                        {
                            modeler:modeler
                            uri:"new:conditionalflow:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"defFlow"//ModelerUtils.getLocalizedString("defFlow")
                    image: "images/flow_defecto1.png"
                    imageOver: "images/flow_defecto2.png"
                    action: function():Void {
                        modeler.disablePannable=true;
                        modeler.tempNode=DefaultFlow
                        {
                            modeler:modeler
                            uri:"new:defaultflow:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"msgFlow"//ModelerUtils.getLocalizedString("msgFlow")
                    image: "images/flow_msj1.png"
                    imageOver: "images/flow_msj2.png"
                    action: function():Void {
                        modeler.disablePannable=true;
                        modeler.tempNode=MessageFlow
                        {
                            modeler:modeler
                            uri:"new:messageflow:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"assocFlow"//ModelerUtils.getLocalizedString("assocFlow")
                    image: "images/doc_dir_asocia1.png"
                    imageOver: "images/doc_dir_asocia2.png"
                    action: function():Void {
                        modeler.disablePannable=true;
                        modeler.tempNode=AssociationFlow
                        {
                            modeler:modeler
                            uri:"new:associationflow:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"dirAssocFlow"//ModelerUtils.getLocalizedString("dirAssocFlow")
                    image: "images/doc_asocia1.png"
                    imageOver: "images/doc_asocia2.png"
                    action: function():Void {
                        modeler.disablePannable=true;
                        modeler.tempNode=DirectionalAssociation
                        {
                            modeler:modeler
                            uri:"new:dirassociationflow:{counter++}"
                        }
                    }
                },
            ]
        }

        var artifacts=SubMenu
        {
            modeler: modeler
            toolBar:this
            text: ##"artifacts"//ModelerUtils.getLocalizedString("artifacts")
            image: "images/anota_1.png"
            imageOver: "images/anota_2.png"
            imageClicked: "images/anota_3.png"
            visible: bind not hidden
            buttons: [
                ImgButton {
                    text: ##"textAnnotation"//ModelerUtils.getLocalizedString("textAnnotation")
                    image: "images/doc_anota1.png"
                    imageOver: "images/doc_anota2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=AnnotationArtifact
                        {
                            modeler:modeler
                            title: ##"textAnnotation"//ModelerUtils.getLocalizedString("textAnnotation")
                            uri:"new:annotationartifact:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"group"//ModelerUtils.getLocalizedString("group")
                    image: "images/doc_grupo1.png"
                    imageOver: "images/doc_grupo2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=GroupArtifact
                        {
                            modeler:modeler
                            title: ##"group"//ModelerUtils.getLocalizedString("group")
                            uri:"new:groupartifact:{counter++}"
                        }
                    }
                }
            ]
        }

        var dataObj = SubMenu
        {
            modeler: modeler
            toolBar:this
            text: ##"dataObjs"//ModelerUtils.getLocalizedString("dataObjs")
            image:"images/doc_1.png"
            imageOver:"images/doc_2.png"
            imageClicked: "images/doc_3.png"
            visible: bind not hidden
            buttons: [
                ImgButton {
                    text: ##"dataObj"//ModelerUtils.getLocalizedString("dataObj")
                    image: "images/doc_normal1.png"
                    imageOver: "images/doc_normal2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=Artifact
                        {
                            modeler:modeler
                            title: ##"dataObj"//ModelerUtils.getLocalizedString("dataObj")
                            uri:"new:artifact:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"collection"//ModelerUtils.getLocalizedString("collection")
                    image: "images/doc_objeto1.png"
                    imageOver: "images/doc_objeto2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=CollectionArtifact
                        {
                            modeler:modeler
                            title: ##"collection"//ModelerUtils.getLocalizedString("collection")
                            uri:"new:multipleartifact:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"dataInput"//ModelerUtils.getLocalizedString("dataInput")
                    image: "images/doc_entrada1.png"
                    imageOver: "images/doc_entrada2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=InputArtifact
                        {
                            modeler:modeler
                            title: ##"dataInput"//ModelerUtils.getLocalizedString("dataInput")
                            uri:"new:inputartifact:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"dataOutput"//ModelerUtils.getLocalizedString("dataOutput")
                    image: "images/doc_salida1.png"
                    imageOver: "images/doc_salida2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=OutputArtifact
                        {
                            modeler:modeler
                            title: ##"dataOutput"//ModelerUtils.getLocalizedString("dataOutput")
                            uri:"new:outputartifact:{counter++}"
                        }
                    }
                },
                ImgButton {
                    text: ##"dataStore"//ModelerUtils.getLocalizedString("dataStore")
                    image: "images/doc_base1.png"
                    imageOver: "images/doc_base2.png"
                    action: function():Void
                    {
                        modeler.disablePannable=true;
                        modeler.tempNode=DataStoreArtifact
                        {
                            modeler:modeler
                            title: ##"dataStore"//ModelerUtils.getLocalizedString("dataStore")
                            uri:"new:datastoreartifact:{counter++}"
                        }
                    }
                }
            ]
        }

        var pool=SubMenu
        {
            modeler: modeler
            toolBar:this
            text: ##"swimLanes"//ModelerUtils.getLocalizedString("swimLanes")
            image: "images/pool_1.png"
            imageOver: "images/pool_2.png"
            imageClicked: "images/pool_3.png"
            visible: bind not hidden
            buttons: [
                ImgButton
                {
                    text: ##"pool"//ModelerUtils.getLocalizedString("pool")
                    image: "images/pool_pool1.png"
                    imageOver: "images/pool_pool2.png"
                    action: function():Void {
                        modeler.disablePannable=true;
                        modeler.tempNode=Pool
                        {
                            modeler:modeler
                            title: ##"pool"//ModelerUtils.getLocalizedString("pool")
                            uri:"new:pool:{counter++}"
                        }
                    }
                },
                ImgButton
                {
                    text: ##"lane"//ModelerUtils.getLocalizedString("lane")
                    image: "images/pool_lane1.png"
                    imageOver: "images/pool_lane2.png"
                    action: function():Void {
                        modeler.disablePannable=true;
                        modeler.tempNode=Lane
                        {
                            modeler:modeler
                            title: ##"lane"//ModelerUtils.getLocalizedString("lane")
                            uri:"new:Lane:{counter++}"
                        }
                    }
                }
            ]
        };
        var flow: Flow;
        var imt: ImageView = null;

        var ret=Group
        {
             layoutX:bind x
             layoutY:bind y
             //scaleX:.5
             //scaleY:.5
             content: [
                flow = Flow {
                    height: bind h
                    width: bind w
                    content: [
                        ImageView {
                            image: imgTitleBar
                            smooth: false
                            cursor:Cursor.MOVE
                            //blocksMouse:true
                            onMousePressed: function (e: MouseEvent): Void
                            {
                                ModelerUtils.clickedNode=this;
                                modeler.disablePannable=true;
                                dx=x-e.sceneX;
                                dy=y-e.sceneY;
                            }
                            onMouseDragged: function (e: MouseEvent): Void
                            {
                                var tx = dx + e.sceneX;
                                var ty = dy + e.sceneY;
                                if (tx >= 0 and e.sceneX <= stage.scene.width) {
                                    x=dx+e.sceneX;
                                }
                                if (ty >= 0 and e.sceneY <= stage.scene.height) {
                                    y=dy+e.sceneY;
                                }
                            }
                            onMouseReleased: function (e: MouseEvent): Void
                            {
                                ModelerUtils.clickedNode=null;
                                modeler.disablePannable=false;
                            }
                        },
                        ImgButton {
                            text: bind if (not hidden) ##"hideTooltip" else ##"showTooltip"
                            toolBar:this;
                            image: bind if (not hidden) "images/sube_1.png" else "images/baja_1.png"
                            imageOver: bind if (not hidden) "images/sube_2.png" else "images/baja_2.png"
                            action: function():Void
                            {
                                ModelerUtils.stopToolTip();
                                hidden = not hidden;
                                if (hidden) {
                                    imt = ImageView {
                                        image: imgBottomBar
                                        smooth: false
                                    };
                                    insert imt after flow.content[1];
                                } else {
                                    if (imt != null) {
                                        delete imt from flow.content;
                                        imt = null;
                                    }
                                }
                            }
                        },
                        ImgButton {
                            text: bind if(not stage.fullScreen) ##"maximizeTooltip" else ##"minimizeTooltip"
                            toolBar:this;
                            image: bind if(not stage.fullScreen) "images/maxim_1.png" else "images/minim_1.png"
                            imageOver: bind if(not stage.fullScreen) "images/maxim_2.png" else "images/minim_2.png"
                            action: function():Void
                            {
                                ModelerUtils.clickedNode=null;
                                modeler.disablePannable=false;
                                stage.fullScreen = not stage.fullScreen;
                            }
                            visible: bind not hidden
                        },
                        file,
                        ImageView {
                            image: imgDiv
                            smooth: false
                            visible: bind not hidden
                            //blocksMouse:true
                        },
                        task,
                        ImageView {
                            image: imgSpace
                            smooth: false
                            visible: bind not hidden
                        },
                        subtask,
                        ImageView {
                            image: imgSpace
                            smooth: false
                            visible: bind not hidden
                        },
                        startEvent,
                        ImageView {
                            image: imgSpace
                            smooth: false
                            visible: bind not hidden
                        },
                        interEvent,
                        ImageView {
                            image: imgSpace
                            smooth: false
                            visible: bind not hidden
                        },
                        endEvent,
                        ImageView {
                            image: imgSpace
                            smooth: false
                            visible: bind not hidden
                        },
                        gateWay,
                        ImageView {
                            image: imgDiv
                            smooth: false
                            visible: bind not hidden
                        },
                        sequence,
                        ImageView {
                            image: imgDiv
                            smooth: false
                            visible: bind not hidden
                        },
                        artifacts,
                        ImageView {
                            image: imgDiv
                            smooth: false
                            visible: bind not hidden
                        },
                        dataObj,
                        ImageView {
                            image: imgDiv
                            smooth: false
                            visible: bind not hidden
                        },
                        pool,
                        ImageView {
                            image: imgBottomBar
                            smooth: false
                            visible: bind not hidden
                        }
                    ]
                },
                file.subBar,
                task.subBar,
                subtask.subBar,
                startEvent.subBar,
                interEvent.subBar,
                endEvent.subBar,
                gateWay.subBar,
                sequence.subBar,
                artifacts.subBar,
                dataObj.subBar,
                pool.subBar
             ]
             cursor:Cursor.HAND;
             blocksMouse:true
        };

        return ret;
    }

    public function undo() : Void
    {
        var aux=undoMgr.undo();
        if(aux!=null)
        {
            delete modeler.contents;
            //modeler.containerElement=null;
            createProcess(aux);
        }
    }

    public function redo() : Void
    {
        var aux=undoMgr.redo();
        if(aux!=null)
        {
            delete modeler.contents;
            //modeler.containerElement=null;
            createProcess(aux);
        }
    }

    function validateProcess() {

    }

//    function getXPDL () : Void {
//        var dbf:DocumentBuilderFactory = DocumentBuilderFactory.newInstance();
//        var docBuilder: DocumentBuilder = dbf.newDocumentBuilder();
//        var doc:Document = docBuilder.newDocument();
//        doc.setXmlStandalone(true);
//
//        var root:Element = doc.createElement("Package");
//        root.setAttribute("xmlns", "http://www.wfmc.org/2008/XPDL2.1");
//        root.setAttribute("xmlns:xpdl", "http://www.wfmc.org/2008/XPDL2.1");
//        root.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
//        root.setAttribute("xmlns:xsd", "http://www.w3.org/2001/XMLSchema");
//        root.setAttribute("Id", "1");
//        root.setAttribute("Name", "Process1");
//        doc.appendChild(root);
//
//        var pkgHeader:Element = doc.createElement("PackageHeader");
//        root.appendChild(pkgHeader);
//
//        var eNode:Element = doc.createElement("XPDLVersion");
//        eNode.setTextContent("2.1");
//        pkgHeader.appendChild(eNode);
//
//        eNode = doc.createElement("Vendor");
//        eNode.setTextContent("SemanticWebBuilder Process Modeler");
//        pkgHeader.appendChild(eNode);
//
//        eNode = doc.createElement("Created");
//        eNode.setTextContent(new Date(System.currentTimeMillis()).toString());
//        pkgHeader.appendChild(eNode);
//
//        var poolsNode = doc.createElement("Pools");
//        root.appendChild(poolsNode);
//
//        var wfNodes = doc.createElement("WorkflowProcesses");
//        root.appendChild(wfNodes);
//
//        for (ele in modeler.contents) {
//            if (ele instanceof Pool) {
//                var p = ele as Pool;
//                poolsNode.appendChild(getPoolBlock(doc, p));
//
//            } else if (ele instanceof Event) {
//                var e = ele as Event;
//            }
//
//        }
//        ////////////////////////
//        var transfac:TransformerFactory = TransformerFactory.newInstance();
//        var trans:Transformer = transfac.newTransformer();
//        //trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
//        trans.setOutputProperty(OutputKeys.INDENT, "yes");
//
//        var sw:StringWriter = new StringWriter();
//        var result:StreamResult = new StreamResult(sw);
//        var source:DOMSource = new DOMSource(doc);
//        trans.transform(source, result);
//        var xmlString = sw.toString();
//
//        println("-----");
//        println(xmlString);
////        println(ret);
//    }

//    function getPoolBlock(doc:Document, p:Pool) : Element {
//        var pNode:Element = doc.createElement("Pool");
//        var lNode:Element = doc.createElement("Lanes");
//        pNode.setAttribute("Process", "pid");
//        pNode.setAttribute("Id", p.uri);
//        pNode.setAttribute("BoundaryVisible", "true");
//        pNode.setAttribute("Name", p.title);
//        for(lane in p.lanes) {
//            lNode.appendChild(getLaneBlock(doc, lane, p));
//        }
//        pNode.appendChild(lNode);
//        pNode.appendChild(getGraphicsInfos(doc, p as GraphicalElement));
//        return pNode;
//    }
//
//    function getLaneBlock(doc:Document, l:Lane, p:Pool) : Element {
//        var lnNode = doc.createElement("Lane");
//        lnNode.setAttribute("Id", l.uri);
//        lnNode.setAttribute("ParentLane", p.uri);
//        lnNode.appendChild(getGraphicsInfos(doc, l as GraphicalElement));
//        return lnNode;
//    }
//
//    function getGraphicsInfos(doc: Document, ge: GraphicalElement) : Element {
//        var lgis = doc.createElement("NodeGraphicsInfos");
//        var lgi = doc.createElement("NodeGraphicsInfo");
//        lgi.setAttribute("Width", "{ge.w}");
//        lgi.setAttribute("Height", "{ge.h}");
//        var coord:Element = doc.createElement("Coordinates");
//        coord.setAttribute("XCoordinate", "{ge.x}");
//        coord.setAttribute("YCoordinate", "{ge.y}");
//        lgi.appendChild(coord);
//        lgis.appendChild(lgi);
//        return lgis;
//    }
//
//    function getEventBlock(e: Event) : String {
//        var trigger = "None";
//        var attachedTo = "";
//        var catchThrow = "";
//        var ret = "<Activity Id=\"{e.uri}\" Name=\"{e.title}\">\n";
//        ret += "  <Event>\n";
//        if (e instanceof StartEvent) {
//            if (e instanceof MessageStartEvent) {
//                trigger = "Message";
//            } else if (e instanceof TimerStartEvent) {
//                trigger = "Timer";
//            } else if (e instanceof RuleStartEvent) {
//                trigger = "Conditional";
//            } else if (e instanceof SignalStartEvent) {
//                trigger = "Signal";
//            } else if (e instanceof MultipleStartEvent) {
//                trigger = "Multiple";
//            }
//            ret += "    <StartEvent Trigger=\"{trigger}\" Implementation=\"Unspecified\">";
//            ret += "    </StartEvent>";
//        } else if (e instanceof IntermediateCatchEvent or e instanceof IntermediateThrowEvent) {
//            if (e.parent instanceof Activity) {
//                var ge = e.parent as GraphicalElement;
//                attachedTo = "Target=\"{ge.uri}\"";
//            }
//
//            if (e instanceof IntermediateCatchEvent) {
//                catchThrow = "CatchThrow=\"CATCH\"";
//            } else if (e instanceof IntermediateThrowEvent) {
//                catchThrow = "CatchThrow=\"THROW\"";
//            }
//
//            if (e instanceof MessageIntermediateCatchEvent or e instanceof MessageIntermediateThrowEvent) {
//                trigger = "Message";
//            } else if (e instanceof TimerIntermediateCatchEvent) {
//                trigger = "Timer";
//            } else if (e instanceof ErrorIntermediateCatchEvent) {
//                trigger = "Error";
//            } else if (e instanceof CancelationIntermediateCatchEvent) {
//                trigger = "Cancel";
//            } else if (e instanceof RuleIntermediateCatchEvent) {
//                trigger = "Conditional";
//            } else if (e instanceof LinkIntermediateCatchEvent or e instanceof LinkIntermediateThrowEvent) {
//                trigger = "Link";
//            } else if (e instanceof SignalIntermediateCatchEvent or e instanceof SignalIntermediateThrowEvent) {
//                trigger = "Signal";
//            } else if (e instanceof CompensationIntermediateCatchEvent or e instanceof CompensationIntermediateThrowEvent) {
//                trigger = "Compensation";
//            } else if (e instanceof MultipleIntermediateCatchEvent or e instanceof MultipleIntermediateThrowEvent) {
//                trigger = "Multiple";
//            }
//
//            ret += "    <IntermediateEvent Trigger=\"{trigger}\" Implementation=\"Unspecified\" {attachedTo}>";
//            ret += "    </IntermediateEvent>";
//        } else if (e instanceof EndEvent) {
//            if (e instanceof MessageEndEvent) {
//                trigger = "Message";
//            } else if (e instanceof ErrorEndEvent) {
//                trigger = "Error";
//            } else if (e instanceof CancelationEndEvent) {
//                trigger = "Cancel";
//            } else if (e instanceof SignalEndEvent) {
//                trigger = "Signal";
//            } else if (e instanceof CompensationEndEvent) {
//                trigger = "Compensation";
//            } else if (e instanceof MultipleEndEvent) {
//                trigger = "Multiple";
//            } else if (e instanceof TerminationEndEvent) {
//                trigger = "Terminate";
//            }
//
//            ret += "    <EndEvent Result=\"{trigger}\" Implementation=\"Unspecified\" {attachedTo}>";
//            ret += "    </EndEvent>";
//        }
//        ret += "  </Event>\n";
//        ret += "</Activity>\n";
//        return ret;
//    }
}

class FileFilter extends javax.swing.filechooser.FileFilter {
    override public function getDescription() : String {
        return ##"swpFileFilter"//ModelerUtils.getLocalizedString("swpFileFilter");
    }

    override public function accept(f: java.io.File) : Boolean {
        return f.isDirectory() or f.getName().endsWith(".swp")
    }
}

class ImageFileFilter extends javax.swing.filechooser.FileFilter {
    override public function getDescription() : String {
        return ##"exportFileFilter"//ModelerUtils.getLocalizedString("exportFileFilter");
    }

    override public function accept(f: java.io.File) : Boolean {
        return f.isDirectory() or f.getName().endsWith(".png")
    }
}