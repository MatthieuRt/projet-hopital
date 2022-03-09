<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "classes.*" %>
<%@ page import = "java.lang.Exception" %>
<%@ page import = "java.util.*" %>
<%
    ArrayList<Patient> patients= new Patient().getPatientList();
 %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="assets/css/bootstrap.css"> 
        <link rel="stylesheet" href="assets/style/index.css"> 
    </head>
    <body>
        
      <nav id="nav" class="navbar navbar-default navbar-fixed-top" style="width: 100%;">
       
                <div class="navbar-header">
                    <p>Hopital</p>
                </div>
      </nav>    
         <h1>Liste des Patients</h1>
        
         <form action="recherche" method="POST" >

          <p id="block1">
              
              Docteur :

              <select  name="docteur" class="form-control" required>
   
                 <option  value="">docteur</option>

              </select>

          </p>
          
             <p id="block2">
              Numéro de chambre :

              <select  name="numero" class="form-control" required>
   
                 <option  value="">numero</option>

              </select>

              </p>
         
         <button type="submit" class="btn btn-primary">Chercher</button>
         </form>
        
    <table id="tableau" class="table table-bordered"  border="1" cellspacing="0" cellpadding="10px" height="">
    <tr id="tab1">
       <th>Nom et Préom(s)</th>
       <th>Date de naissance</th>
       <th>Docteur traitant</th>
       <th>Numéro de Chambre</th>
     <tr>

    <%
    for (int i = 0; i < patients.length(); i++) {

    %>
    <tr>
        <td><% out.println(patient[i].getNomPrenom());%></td>
    	<td><% out.println(patient[i].get);%></td>
        <td><% out.println(patient[i].get);%></td>
	    <td><% out.println(patient[i].get);%></td>
        
    </tr>
    <%}%>
    </table>
        
         
         <p id="ajout"><a href="Ajouter.jsp">Ajouter un patient</a></p>
          
          <script src="assets/js/jquery.js"></script>
          <script src="assets/js/bootstrap.min.js"></script>
    </body>
</html>
