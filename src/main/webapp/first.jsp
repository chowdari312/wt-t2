<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <title>Document</title>
  <style>
    :root{
      --color-primary:blue;
      --color-white:white;
      --color-black:black;
      --color-black-1:black;
    }
    *{
      margin:0;
      padding: 0;
      box-sizing: border-box;
    }
    body
    {
      font-family: cursive;
    }
    .menu__bar
    {
      background-color:black;
      height:60px;
      width:100%;
      display: flex;
      
    
      padding:0 5%;
      position: sticky;
      top: 0;
      z-index: 1;
    }
    .menu__bar ul{
      list-style-type: none;
      display: flex;
    }
    .menu__bar ul li
    {
      padding:10px 30px;
      position: relative;
    }
    .menu__bar ul li a 
    {
      text-decoration: none;
      color: aliceblue;
      font-size: 20px;transition:0.5s;
    }
    .menu__bar ul li a:hover
    {
      color:aqua;
    }
    .menu__bar ul li i {
    vertical-align: middle;
}
.drop
{
  display: none;
  position:absolute;
  left:0;
  top:100%;
  background-color: white;
  border-radius:7%;
  text-align:center;
  color:black;
}
.drop ul li a
{color:black}

.drop ul
{
  display:block;

}
.drop ul li{
  width:130px;
  padding:5px;
}
.a{
width:100%;
height:700px;
}
.u
{
  display: none;
 position:absolute;
  right:0px;
  top:62px;
  background-image: url('https://images.pexels.com/photos/673648/pexels-photo-673648.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1');
  border-radius: 0px 0px 10%;
  height: 330px;
  width:410px;
  border: 2px solid black;
  color:black;
}
</style>
</head>
<body>
	<marquee><h3>Welcome <%= session.getAttribute("name") %></h3></marquee>
    <div class="menu__bar">
      <ul>
        <li><a href="first.jsp" target="first.jsp">Home</a></li>
        <li><a href="#">Courses<i class="fa fa-caret-down" style="font-size:24px"></i></a>
       <div class="drop">
        <ul>
          <li><a href="<%= session.getAttribute("course") %>.html" target="logo.html">${course}</a></li>
        </ul>
       </div></li>
        <li><a href="#">Profile</a></li>
        <div class="u">
          <table style="border-spacing: 20px;">
            <tr>
              <td><strong>Name:</strong></td>
              <td><%= session.getAttribute("name") %></td>
            </tr>
            <tr>
              <td><strong>Email:</strong></td>
              <td><%= session.getAttribute("email") %></td>
            </tr>
            <tr>
              <td><strong>Mobile:</strong></td>
              <td><%= session.getAttribute("mobile") %></td>
            </tr>
            <tr>
              <td><strong>Course:</strong></td>
              <td><%= session.getAttribute("course") %></td>
            </tr>
            <tr>
              <td><strong>Percentage:</strong></td>
              <td><%= session.getAttribute("percentage") %></td>
            </tr>
            <tr>
              <td><strong>Education Qualification:</strong></td>
              <td><%= session.getAttribute("eduqf") %></td>
            </tr>
            <tr>
              <td><strong>Logout:</strong></td>
              <td><a href="index.html" style="text-decoration: none; 
              border-radius: 8px;padding:4px 8px; background:transparent;color: black;" >Click_to_logout</a></td>
            </tr>
          </table>
        </div>
         <li><a href="index.html">Logout</a></li>
        
      </ul>
    </div>
   
<script>
var coursesLink = document.querySelector('.menu__bar ul li:nth-child(2) a');
var dropdown = document.querySelector('.drop');

coursesLink.addEventListener('click', function(event) {
  event.preventDefault();
  if (dropdown.style.display === 'block') {
    dropdown.style.display = 'none';
  } else {
    dropdown.style.display = 'block';
  }
});

var profileLink = document.querySelector('.menu__bar ul li:nth-child(3) a');
    var userProfile = document.querySelector('.u');

    profileLink.addEventListener('click', function(event) {
      event.preventDefault();
      if (userProfile.style.display === 'block') {
        userProfile.style.display = 'none';
      } else {
        userProfile.style.display = 'block';
      }
    });
</script>
  <i>Welcome to our online learning platform.....</i>

</body>
</html> 
