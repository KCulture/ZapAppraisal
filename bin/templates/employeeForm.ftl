<!DOCTYPE html>
<html>
<head>
    <title>Employee Appraisal ${model.contact1.firstName}! </title>
</head>
<body>
    <div id='root'></div>
    
    <script src="https://fb.me/react-15.0.1.js"></script>
    <script src="https://fb.me/react-dom-15.0.1.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.23/browser.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/babel">
    
    var Contact = React.createClass({
    getInitialState: function () {
    return {id:"",c1:this.props.contact.firstName,c2:this.props.contact.lastName,c3:this.props.contact.email};
    },
    render: function(){
    
    
    return (
      <div className="row">
                  <div className="col-lg-3">
                    Contacts{this.props.index}:
                  </div>
                  <div>
                    <input type="text" onChange={this.changer1} value={this.state.c1} placeholder="Enter Contact Firstname"/>
                    <input type="text" onChange={this.changer2}value={this.state.c2} placeholder="Enter Contact Lastname"/>
                    <input type="text" onChange={this.changer3}value={this.state.c3} placeholder="Enter Contact Email"/>
                  </div>  
     </div>
    
    );
    },
    changer1: function(e){
     this.setState({c1:e.target.value});
    },
    changer2: function(e){
     this.setState({c2:e.target.value});
    },
    changer3: function(e){
     this.setState({c3:e.target.value});
    }
    });
    
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
    let a = this.refs['c0'].state.c1;
    let currentContacts = [];
    let currentAnswers = [];
    var employee = JSON.parse("${model.employee?j_string}");
    let me = this;
    employee.contacts.forEach(function(contact,index){
    currentContacts.push({firstName:me.refs["c"+index].state.c1,lastName:me.refs["c"+index].state.c2,email:me.refs["c"+index].state.c3,
    questions:contact.questions,answers:contact.answers})
    });
    employee.answers.forEach(function(answer,index){
     currentAnswers.push(me.refs["qa"+index].state.answer);
    });
    employee.contacts = currentContacts;
    employee.answers = currentAnswers;
    
    $.ajax({
      headers: { 
        Accept : "application/json; charset=utf-8",
        "Content-Type": "application/json; charset=utf-8",
      },
      type:'PUT',
      url: "http://localhost:8080/appraisals/employees/"+employee.id,
      data: JSON.stringify(emp)
      
      })
    },
  
     
   render: function() {
    let contact1 = JSON.parse("${model.contact1?j_string}");
    let contact2 = JSON.parse("${model.contact2?j_string}");
    let employee = JSON.parse("${model.employee?j_string}");
    let answers = employee.answers;
    let sup = [] ;
    let qaPair = [];
    employee.questions.forEach(function(questions,index){sup.push(
      <FormQA question={questions[index]} answer={answers[index]} key={index} ref={"qa"+index} />
    )});
     employee.contacts.forEach(function(contact,index){
      qaPair.push(<Contact contact={contact} index={index+1} ref={"c"+index} key={index}/>);
    });
    
    
    
   
   
    return (<div className="panel panel-primary">
              <div className="panel-heading">
                <h3 className="panel-title"> Application Form </h3>
              </div>
              <div className="panel-body" ref="body">
                <div className="row">
                  <div className="col-lg-3" >
                    Firstname:${model.employee.firstName}
                  </div>
                </div>
                
                <div className="row">
                  <div className="col-lg-3">
                    LastName:${model.employee.lastName}
                  </div>
                </div>
                <div className="row">
                  <div className="col-lg-3">
                    Hire Date:${model.employee.hireDate?date}
                  </div>
                </div>
                
                <div className="row">
                  <div className="col-lg-10">
                    Email:${model.employee.email}
                  </div>
                </div>
              <div className="container">  
                {qaPair}
                {sup}
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