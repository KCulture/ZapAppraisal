<!DOCTYPE html>
<html>
<head>
    <title>React + Spring</title>
</head>
<body>
    <div id='root'></div>
 
    <script type="text/babel">
var Employee = React.createClass({
  render: function() {
    return (<div>employee insode</div>);
  }
});
var EmployeeTable = React.createClass({
  render: function() {
    return (<div>employee table <Employee /></div>);
  }
});
 
ReactDOM.render(
  <EmployeeTable />, document.getElementById('root')
);
</script>

 <script src="https://fb.me/react-15.0.1.js"></script>
    <script src="https://fb.me/react-dom-15.0.1.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.23/browser.min.js"></script>
 
</body>
</html>