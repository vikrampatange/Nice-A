<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="com.nice.service.* ,com.nice.util.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>NICE-A|SAG GRAPH</title>
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
                .........................................Scenario Attack Graph [SAG]</a>
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
					boolean isOneOfTheZombie=controlCenterService.isOneOfTheZombie();
					boolean isOneOfTheExploited=controlCenterService.isOneOfTheExploited();
		%>
   
      
  <ul id="org" style="display:none">
    <li>
          [Nr Node]
       <ul>
       
         <li id="beer">Type[Nc]
         
         <ul>
            <%if((logincount!=0)) {%>
             <li>Login </li>
             <%}%>
             
             
             <%if((logincount!=0)) {%>
             <li>Brute-force attack </li>
             <%}%>
             
             
             
             <%if((sqlcount!=0)) {%>
             <li>Sql Attack </li>
             <%}%> 
             
             <%if((scriptcount!=0)) {%>
             <li>Xss Script </li>
             <%}%>
            
           </ul>
         </li>
          <li id="beer">*</li>
         <li class="fruit">VM State [Nd]
           <ul>
             <%if((logincount==0)&& (sqlcount==0) && (scriptcount==0)) {%>
             <li>Stable </li>
              <%}%>
              
              <%if((logincount!=0) && isOneOfTheZombie==false && isOneOfTheExploited==false) {%>
             <li>Vulnerable </li>
             <%}%>
             
             <%if((scriptcount!=0)|| (sqlcount!=0) ) {%>
             <li>Exploited </li> 
              <%}%>
              
              <%if(isOneOfTheZombie==true&& logincount!=0) {%>
             <li>Zombie </li>
              <%}%>
            
           </ul>
         </li>
    <!--       <li id="beer">*</li> -->
       
        
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