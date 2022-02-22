<%-- 
    Document   : index
    Created on : 22 févr. 2022, 11:30:59
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="assets/css/bootstrap.css"> 
    </head>
    <body>
         <p class="text-center">Liste des Patients</p>
        
         <form action="recherche" method="POST" >

          <p>
              Docteur :

              <select name="docteur" class="form-control" required>
   
                 <option value="">docteur</option>

              </select>

          </p>
          
             <p>
              Numéro de chambre :

              <select name="numero" class="form-control" required>
   
                 <option value="">numero</option>

              </select>

              </p>
         
         <button type="submit" class="btn btn-primary">Chercher</button>
         </form>
        
         <a href="Ajouter.jsp">Ajout patient</a>
          <script src="/assets/js/jquery.js"></script>
          <script src="assets/js/bootstrap.min.js"></script>
    </body>
</html>
