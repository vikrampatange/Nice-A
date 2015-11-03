<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="com.nice.service.* ,com.nice.util.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>NICE-D|ACG GRAPH</title>
    <link rel="stylesheet" href="graph/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="graph/css/jquery.jOrgChart.css"/>
    <link rel="stylesheet" href="graph/css/custom.css"/>
    <link href="graph/css/prettify.css" type="text/css" rel="stylesheet" />

    <script type="text/javascript" src="graph/prettify.js"></script>
    
    <!-- jQuery includes -->
    <script type="text/javascript" src="graph/js/jquery-ui-1.8.3.min.js"></script>
    <script type="text/javascript" src="graph/js/jquery-ui-1.8.3.min.js"></script>
    
    <script src="graph/jquery.jOrgChart.js"></script>

    <script>
    jQuery(document).ready(function() {
        $("#org").jOrgChart({
            chartElement : '#chart',
            dragAndDrop  : true
        });
    });
    </script>
  </head>

  <body onload="prettyPrint();">
    <div class="topbar">
        <div class="topbar-inner">
            <div class="container">
                              <a  class="brand" href="#">
                .........................................Attack and Alert Correlation Graph- [ACG]</a>
                <!-- <ul class="nav">
                    <li><a href="http://github.com/wesnolte">Github</a></li>
                    <li><a href="http://twitter.com/wesnolte">Twitter</a></li>                  
                    <li><a href="http://th3silverlining.com">Blog</a></li>      
                </ul> -->
                <div class="pull-right">
                  <!--   <div class="alert-message info" id="show-list">Show underlying list.</div> -->
                    
<pre class="prettyprint lang-html" id="list-html" style="display:none"></pre>       
                </div>              
            </div>
        </div>
    </div>
    
    
    
     <%
     
     
       response.setIntHeader("Refresh", 5);
       ControlCenterService controlCenterService=new ControlCenterService();
					int logincount  =controlCenterService.getLoginAttackCount();
					int sqlcount =controlCenterService.getSqlAttackCount();
					int scriptcount = controlCenterService.getScriptAttackCount();
									
		%>
    
    
  <ul id="org" style="display:none">
    <li>
      Attack
       <ul>
           <!-- Start Of Login -->
          <%if((logincount!=0)) {%> 
         <li id="beer">Login
         
         <ul>
             <%
             for(int i=1;i<=logincount;i++) 
            {
            %>
            
             <li>Login <%=i %></li>
             
           <%} %>
           
           
           </ul>
         </li>
         
          <%} %>
         <!-- End Of Login -->
         
         
         
         
         <!-- Start Of brutforce attck -->
          <%if((logincount!=0)) {%> 
         <li id="beer">#Brute-force attack
         
         <ul>
             <%
             for(int i=1;i<=1;i++) 
            {
            %>
            
             <li>Brute-force attack-1 <%=1 %></li>
             
           <%} %>
           
           
           </ul>
         </li>
         
          <%} %>
         <!-- End Of brutforce -->
         
         
         
         
         
         
         
         <!--  <li id="beer">*</li> -->
      
         <!-- Sql Injection -->
          <%
          if((sqlcount!=0)) 
          {
          %> 
         <li class="fruit">#Sql Injection
           <ul>
             <%for(int i=1;i<=sqlcount;i++) 
            {%>
             <li>Sql <%=i %></li>
             
            <%} %>
           
           </ul>
         </li>
             <%} %>
          <!-- End Of Sql Injection -->
         
          <!-- <li id="beer">*</li> -->
          
           <!-- Start Of XSS Attack -->
           <%if((scriptcount!=0)) {%> 
         <li class="fruit">#XSS Attack
           <ul>
             <%for(int i=1;i<=scriptcount;i++) 
            {%>
             <li>XSS Attack <%=i %></li>
             
             <%} %>
           
           </ul>
         </li>
          <%} %>
          <!-- End Of XSS Attack -->
          
          <!-- Start Of Other -->
        <!--  <li >Other
           
           <ul>
             <li>Topdeck</li>
             <li>Reese's Cups</li>
           </ul>
         </li> -->
          <!-- End Of Other -->
       </ul>
     </li>
   </ul>                
    
    <div id="chart" class="orgChart"></div>
     
    <script>
        jQuery(document).ready(function() {
            
            /* Custom jQuery for the example */
            $("#show-list").click(function(e){
                e.preventDefault();
                
                $('#list-html').toggle('fast', function(){
                    if($(this).is(':visible')){
                        $('#show-list').text('Hide underlying list.');
                        $(".topbar").fadeTo('fast',0.9);
                    }else{
                        $('#show-list').text('Show underlying list.');
                        $(".topbar").fadeTo('fast',1);                  
                    }
                });
            });
            
            $('#list-html').text($('#org').html());
            
            $("#org").bind("DOMSubtreeModified", function() {
                $('#list-html').text('');
                
                $('#list-html').text($('#org').html());
                
                prettyPrint();                
            });
        });
    </script>

</body>
</html>