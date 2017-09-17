<!DOCTYPE html>
<html>
<head>
    <title>Responder Feedback ${model.responder.firstName}! </title>
</head>
<body>
    <div id='root'></div>
    
    <script src="https://fb.me/react-15.0.1.js"></script>
    <script src="https://fb.me/react-dom-15.0.1.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.23/browser.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/babel">
    
    var FormQA = React.createClass({
    getInitialState: function () {
    return {answer:this.props.answer};
    },
     render: function(){
       return (
         <form className="form-horizontal">
       <div className="form-group">
        <label for="inputEmail" className="control-label col-xs-2">{this.props.question}</label>
        <div className="col-xs-10">
            <input type="email" className="form-control" value={this.state.answer} id="inputEmail" placeholder="Email" onChange={this.renew}/>
        </div>
       </div>
      </form>
       );
     },
    renew: function(e){
     this.setState({answer:e.target.value});
    } 
   });
    
    var App = React.createClass({
    
    st:function(){
    
    let currentAnswers = [];
    var responder = JSON.parse("${model.responder?j_string}");
    let me = this;
    
    responder.answers.forEach(function(answer,index){
     currentAnswers.push(me.refs["qa"+index].state.answer);
    });
    
    responder.answers = currentAnswers;
     
   
    $.ajax({
      headers: { 
        Accept : "application/json; charset=utf-8",
        "Content-Type": "application/json; charset=utf-8",
      },
      type:'PUT',
      url: "http://localhost:8080/appraisals/responders/"+responder.id,
      data: JSON.stringify(responder)
      
      })
    },
  
     
   render: function() {
    let responder = JSON.parse("${model.responder?j_string}");
    let answers = responder.answers;
    let qaPair = [];
    responder.questions.forEach(function(questions,index){qaPair.push(
      <FormQA question={questions[index]} answer={answers[index]} key={index} ref={"qa"+index} />
    )});
     
    
    return (<div className="panel panel-primary">
              <div className="panel-heading">
                <h3 className="panel-title"> Application Form </h3>
              </div>
              <div className="panel-body" ref="body">
                <div className="row">
                  <div className="col-lg-3" >
                    Firstname:${model.responder.firstName}
                  </div>
                </div>
                
                <div className="row">
                  <div className="col-lg-3">
                    LastName:${model.responder.lastName}
                  </div>
                </div>
                <div className="row">
                  <div className="col-lg-10">
                    Email:${model.responder.email}
                  </div>
                </div>
              <div className="container">  
                {qaPair}
              </div>  
              <button className="bnt" onClick={this.st}>Update</button>
              
              
              </div>
            </div>);
    }
    
    
   });
        
    ReactDOM.render(<App/>, document.getElementById('root'));
    </script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</body>
</html>