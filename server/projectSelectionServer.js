module.exports = function (app) {
  console.log("wwwwwwwwwwwwwwwww");
var mongojs=require('mongojs');
  var db=mongojs('collections',['asd'])
  // var db=mongojs('collections',['asd'])
  const multer=require('multer')
const GridFsStorage=require('multer-gridfs-storage')
const gridfs=require('gridfs-stream')

// var mongoose  = require('mongoose');

  var mongoose  = require('mongoose');
mongoose.connect('mongodb://localhost:27017/collections')
mongoose.Promise = global.Promise;

gridfs.mongo = mongoose.mongo;
var connection = mongoose.connection;
  const mongoURI = 'mongodb://localhost:27017/collections';
const conn = mongoose.createConnection(mongoURI);
var gfs;
conn.once('open', () => {
  // Init stream
  gfs = gridfs(conn.db, mongoose.mongo);
 
   gfs.collection('folder');
//   gfs.files.find().toArray(function (err, files) {
 
//     console.log(files.length)
//     console.log(files)
// })  

});
var fs = require('fs');
var shell = require("shelljs");
// gfs = gridfs(conn.db, mongoose.mongo);
// gfs.collection('folder');
 
//Create storage engine
const storage = new GridFsStorage({
  url: mongoURI,
  file: (req, file) => {
    return new Promise((resolve, reject) => {
      //crypto.randomBytes(16, (err, buf) => {

        var path = req.params.a;
        var latestPath =   path.replace(/[-]/gi, '/');
       
        let data_Array = latestPath.split("/");
     
        var latestPath123 = data_Array.splice(data_Array.length-1);
 var myJSON = JSON.stringify(latestPath123);
           
             latestPath = latestPath.substring(0, latestPath.length - myJSON.length+3); // "12345.0"
     
      
       // var newDestination = 'uploads/' + latestPath;




        // if (err) {
        //   return reject(err);
        // }
        
        const filename = file.originalname;
       

        const fileInfo = {
            metadata:'uploads/'+latestPath,
          filename:filename,
          contentType :data_Array[0],
          bucketName: 'folder'
        };
        resolve(fileInfo);
    //  });
    });
  }
});
const upload = multer({ storage });

//var a = 1;
app.post("/projectSelection/:a",upload.any(),function(req, res) {

let lengthCount = Number(req.body.totalLength-1);
 if( Number(req.body.currentLength) === Number(req.body.totalLength-1)){
    let projectName = req.files[0].fieldname.split("/");
    var trialCall = function() {
        //  setTimeout(function() {
          //console.log("Task 311111111111113333333333333333333333333333  ");
         // conn.once('open', () => {
            // Init stream
            // gfs = gridfs(conn.db, mongoose.mongo);
           
            //  gfs.collection('folder');
           var  lengthCount =1910;
          gfs.files.find({contentType:projectName[0]}).toArray(function (err, files) {
      
            //console.log("files length  "+files.length)
             let lengthCheck = files.length -1 ; 
             var totalfiles=files.length
           //  console.log(files)
             let i = 0;
            // for(m =1;m<=lengthCount;m++){
               //console.log(" heelo 3 "+i)
    
           //return new Promise((resolve, reject) => {
      
               
             //files.forEach(function(files) {
                //trialcall1(0)
                let m =0;
              var  trialcall1 =  function(m){
                    if(m=== lengthCheck){
                      //   setTimeout(function(){

                      
                      //   createDbs(files[m].contentType)
                    
                      // },30000);
                       // createDbs(files[m].contentType)
                        //console.log(m+" no loop "+"   "+files[m].filename) 
                    }else{
                    	   //var wait=parseInt(m*14);
               setTimeout(function() {
                        shell.mkdir('-p',"./"+files[m].metadata)
      
             const stream = gfs.createReadStream(files[m].filename);
      
          var eam = fs.createWriteStream(__dirname+"/"+files[m].metadata+"/"+files[m].filename);
      
      
              stream.pipe(eam);
          },3000)
              m++;
              console.log(m+" no loop "+"   "+totalfiles) 
                                 if(m==totalfiles-1){
                     // console.log("ouyyyyyyyyyyyyyyyyyyy")
         //waitfor()
          console.log(files[m].contentType+"OOOPppppp")
               //      var wait=parseInt(m*14);
               // setTimeout(function() {
  //wait function must bec files will created but data inside file not created bec
  //of that testscript will wont work 
 
        createDbs(files[m].contentType)
        res.json("Imported Succesffully")


      // },wait)
       
 
        
             }
              //console.log(m+" exectutr loop "+"   "+files[m].filename) 
                        trialcall1(m)
                    }
                }  
                trialcall1(0)
             
      
      
            })
    
            // resolve(fileInfo);
            
       // });
          // }//)
        // })//gfs
       // }) 
      
          }
    //  console.log("iam project"+ projectName[0]);
    trialCall();

}   
else{
res.json([]);
}
    
});
var trialCall123 = function() {
    //  setTimeout(function() {
      //console.log("Task 311111111111113333333333333333333333333333  ");
      conn.once('open', () => {
        // Init stream
        gfs = gridfs(conn.db, mongoose.mongo);
       
         gfs.collection('folder');
       var  lengthCount =1910;
      gfs.files.find({contentType:"projectjavatriall7564"}).toArray(function (err, files) {
  
        //console.log("files length  "+files.length)
         let lengthCheck = files.length - 1 ; 
       //  console.log(files)
         let i = 0;
        // for(m =1;m<=lengthCount;m++){
           //console.log(" heelo 3 "+i)

       //return new Promise((resolve, reject) => {
  
           
         //files.forEach(function(files) {
            //trialcall1(0)
            let m =0;
          var  trialcall1 =  function(m){
                if(m==lengthCheck){
                   // console.log(m+" no loop "+"   "+files[m].filename) 
                    
                   // setTimeout(, 1500 );
                    // setTimeout(function(){

                    //     // Current time in milliseconds
                    //     //console.log(new Date().getTime()); 
                    //     createDbs(files[m].contentType)
                    
                    //   },15000);
                }else{
                    shell.mkdir('-p',"./"+files[m].metadata)
  
         const stream = gfs.createReadStream(files[m].filename);
  
      var eam = fs.createWriteStream(__dirname+"/"+files[m].metadata+"/"+files[m].filename);
  
  
          stream.pipe(eam);
          m++;
          //console.log(m+" exectutr loop "+"   "+files[m].filename) 
                    trialcall1(m)
                }
            }  
            trialcall1(0)
         
  
  
        })

        // resolve(fileInfo);
        
   // });
      // }//)
     })//gfs
   // }) 
  
      }
   //  trialCall();
//trialCall123();
   //  setTimeout(trialCall, 1500 );
    //  setImmediate(() => {
    //     trialCall()
    //     console.log(`executing immediate: `);
    //   }, 'so immediate');
      

// var j = 0;
// var trialcall1 = function(j){
//     j++;
//     if(j<=10){
//         console.log(" enter the j " +j)
//         trialcall1(j)
//     }else{
//         console.log(" finish the j "+j)
//        // trialcall1(j)
//     }

// }

//trialcall2()


//



var  call = function(metadata,filename,i){
    //console.log(" i "+i)
    shell.mkdir('-p',"./"+metadata)

    const stream = gfs.createReadStream(filename);

 var eam = fs.createWriteStream(__dirname+"/"+metadata+"/"+filename);


     stream.pipe(eam);
  }


  var moduleCount = 1;
var createDbs = function(folderName) {
	console.log("iiiiiiiiiii")
    moduleCount = 1;
   
    const Filehound = require('filehound');
    

Filehound.create()
  .ext('feature')
 // .match('*a*')
  .paths("./uploads"+"/"+folderName)
  .find((err, htmlFiles) => {
      let start = 1;
    if (err) return console.error("handle err", err);
 var cc=0;
 var ff=0;
 var pI=1;
db.projectSelection.insert({"projectSelection":folderName,"projectId":pI})
 //console.log("filewwwwwwwwwwwwwwwwwwwwwwwww ")


    htmlFiles.forEach(function(file) {
   // ff++
      
    let data_Array = file.split("\\");
    // console.log("cccccccccccc"+cc++)
    // console.log("ffffffffffff"+ff++)
var dd=1;
var rr=ff++


       createModuleAndFeature(file,data_Array,dd,rr,pI);
   });
 
  });
}//createDbs ()

//createDbs("projectjavatriall75645")
 // var incId=0;
 //    for (var j =0;j<=5; j++) {
 //     console.log(incId++)
 //     //console.log(j++)
 
 //   }
//
let createModuleAndFeature = function(data,data_Array,dd,rr,pI){
    // for module creation 
   //var cc=0;
  //console.log("eeeeeeeeeeeeeeeeee  "+data);
   //console.log("wwwwwwwwwwww  "+data_Array);
   let modulesName = data.split("\\",(data_Array.length-1)).pop() ;
    //console.log("modulesNameeeeeeeeeeeeeeeeee  "+modulesName);
  if(moduleCount === 1){
        db.moduleName.insert({"moduleName":modulesName,"moduleId":dd,"projectId":pI})
        moduleCount++
    }else{
        //console.log(moduleCount+"   modulesNameeeeeeeeeeeeeeeeee  "+modulesName);
    }
   //cc++
   // var moduleId=0
   // for(var j=0;j<=data_Array.length-1;j++){
   //  //moduleId++
   //      db.modulesName.insert({"moduleId":moduleId++})
   // }
   // for feature creation 
    let featureNames = data.split("\\",(data_Array.length)).pop() ;
    let featureNameWitoutExt = featureNames.replace(".feature", "");
    db.featureName.insert({"featureName":featureNameWitoutExt,"featureId":rr,"moduleId":dd,"projectId":pI})
    createTestScript( data,featureNameWitoutExt,rr,dd,pI)


}
let createTestScript = function(file,featureName,rr,dd,pI){
//console.log( "qqqqqqqqqqqqqqqqqq");
    let count =1;
    //console.log(file);
    var LineByLineReader = require('line-by-line');
   // lr = new LineByLineReader("./uploads/projectjavatriall756/Sample1/Features/abc.feature")
   // lr = new LineByLineReader("uploads/projectjavatriall7564/Sample1/Features/abc.feature")
    lr = new LineByLineReader(file)
    //console.log(lr)
    lr.on('error', function (err) {
        // 'err' contains error object
        //console.log(" error rr rr rr ")
    });
    
    lr.on('line', function (line) {
        //console.log(" line line rr rr rr ")
        //console.log(count +" "+line)
        if(line.includes("Scenario") == true){
          //console.log("oooooooooooooooooooooooooooooooooooooo")
            var res = line.substr(line.indexOf(":")+1);
            db.testScript.insert({"scriptName":res,"featureId":rr,"moduleId":dd,"scriptId":count,"lineNum":count,"projectId":pI})
    
         // console.log(count+"   Scenario  true ")
          count++;
    
        }else{
            count++;
          //  console.log(" false  ")    
        }
        
        // 'line' contains the current line without the trailing newline character.
    });
    
    lr.on('end', function () {
        console.log("  end end  Scenario  true ")
        // All lines are read, file is closed now.
    });
}
 app.get('/getTestScriptDetails',function(req,res){
    console.log("getTestScriptDetails")      
    db.testScript.find({},function(err,doc){
    res.json(doc);
    console.log(doc);
    })
})

app.post('/savingImportData',function(req,res) {
    console.log("data data data data data data data data");
 
   db.importScript.insert(req.body,function(err,doc){
 //console.log("5gggggggggggggggggggggggg")
         res.json(doc);
         //console.log(doc);
       })
 
 })
 app.post('/postModuleName',function(req,res)
 {
    //var moduleName=req.params.moduleName;
    
     //var moduleName = str_array[1];
 console.log(req.body.moduleName)
 
 
     db.moduleName.insert(req.body ,function(err,doc)
         {
         res.json(doc);
     
        });
 
 
 })
 app.post('/postFeatureName',function(req,res)
 {
 
    //var moduleName=req.params.moduleName;
    
     //var moduleName = str_array[1];
 //console.log("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk")
 
     db.featureName.insert(req.body ,function(err,doc)
         {
         res.json(doc);
         //console.log(doc)
        });
 
 
 })
app.get('/loginDetails',function(req,res){
     
    // console.log("ooooooooooooooooooo")
     db.loginDetails.find({"userName":"Admin"},function(err,doc){        
         res.json(doc);
         // console.log("kkkkkkkkkkkkkkk"+doc)
     })
 })
 app.get('/selectionProject',function(req,res){
      
   
     db.projectSelection.find({},function(err,doc){        
         res.json(doc);
         // console.log("mm"+doc)
     })
 })
 app.get('/importType',function(req,res){
      
   console.log("kkkkkkkkkkkkkkkkkkkkk")
     db.types.find({},function(err,doc){        
         res.json(doc);
          //console.log(doc)
     })
 })
 app.get('/importPriority',function(req,res){
      
   
     db.priority.find({},function(err,doc){        
         res.json(doc);
         // console.log("mm"+doc)
     })
 })
 // app.get('/idIncrement',function(req,res){
      
 //   console.log("kkkkkkkkkkkkkkkk")
 //     db.dataIds.find({},function(err,doc){        
 //         res.json(doc);
 //         console.log(doc)
 //     })
 // })
 app.get('/getModuleName',function(req,res){
      
      
   
     db.moduleName.find({},function(err,doc){        
         res.json(doc);
        // console.log(doc)
     })
     // db.moduleName.find({}).sort({_id:-1}).limit(1,function(err,doc)
     // {
     //     res.json(doc);
     //     //console.log(doc);
     // })
 })
 app.get('/idModule',function(req,res){
      
      
   
  
     db.moduleName.find({}).sort({_id:-1}).limit(1,function(err,doc)
     {
         res.json(doc);
         //console.log(doc);
     })
 })
 app.get('/idFeature',function(req,res){
      
      
   
  
     db.featureName.find({}).sort({_id:-1}).limit(1,function(err,doc)
     {
         res.json(doc);
         //console.log(doc);
     })
 })
 app.get('/featureName',function(req,res){
      
      
   
     db.featureName.find({},function(err,doc){        
         res.json(doc);
         //console.log(doc)
     })
 })
 // app.get('/getMoId:mI',function(req,res){
 //      console.log("llllllllllllllllll")
 //      var moduleName=req.params.mI
 //      //moduleName1 = parseInt(moduleName1);
 //   //console.log(moduleName1+"llllllllllllllllll")
 //     db.moduleName.find({"moduleName":moduleName},function(err,doc){        
 //         res.json(doc);
 //         console.log(doc)
 //     })
 // })
 app.get('/getMoId:mI',function(req,res){
   console.log("mmmmmmmmmmmmmmmmmm")
    var moduleName=req.params.mI
   db.moduleName.aggregate([
 {$match:{"moduleName":moduleName}},
 
 
 
 {"$lookup":
     {"from":"featureName",
       "localField":"moduleId",
         "foreignField":"moduleId",
          "as":"unitedFM"
      }
  }
 ],function(err,doc){
   res.json(doc);
   //console.log(doc)
 })
 
 })
 app.get('/mId:mN',function(req,res){
      console.log("llllllllllllllllll")
      var moduleName=req.params.mN
      //moduleName1 = parseInt(moduleName1);
   console.log(moduleName+"llllllllllllllllll")
     db.moduleName.find({"moduleName":moduleName},function(err,doc){        
         res.json(doc);
        // console.log(doc)
     })
 })


}//module exports