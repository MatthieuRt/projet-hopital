<%-- 
    Document   : Ajouter
    Created on : 22 févr. 2022, 16:52:01
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <link rel="stylesheet" href="assets/css/bootstrap.css"> 
        <link rel="stylesheet" href="assets/style/index.css"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/css/bootstrap.css"> 
        <link rel="stylesheet" href="assets/style/ajout.css"> 
        <title>JSP Page</title>
    </head>
    <body>
        
        <p id="p1" class="text-center">Ajout d'un patient</p>
        
          <form id="form" action="ajout" method="post">
            
              <div  class="form-group">
                  <div class="input-group">
                        <input id="nom" name="nom"  type="text" class="form-control" placeholder="Nom et prénom(s)" required>
                        
                  </div>
              </div>
              
                <div  class="form-group">
                  <div class="input-group">
                       <p>Date de naissance :</p>
                        <input id="date1" name="date_naissance"  type="date" class="form-control" placeholder="jj/mm/aaaa" required>
                        
                  </div>
                </div>
              
                  <div  class="form-group">
                     <div class="input-group">
                        <input id="adresse" name="adresse"  type="text" class="form-control" placeholder="Adresse" required>
                        
                      </div>
                  </div>
              
                     <div  class="form-group">
                       <div class="input-group">
                           <select id="medecin" name="medecin" class="form-control" required> 
                                <option  value="">Selectionner medecin</option>
                           </select>
                       </div>
                     </div>
              
                      <div  class="form-group">
                        <div class="input-group">
                             <select id="chambre" name="chambre" class="form-control" required> 
                                <option  value="">Selectionner chambre</option>
                             </select>
                        </div>
                      </div>
                      
                        <div class="form-group">
                           <div class="input-group">
                              <p>Date d'entrée :</p>
                              <input id="date2"  name="date_entree"  type="date" class="form-control" placeholder="jj/mm/aaaa" required>       
                            </div>
                        </div>
                       
                        <div id="" class="form-group">
                            <div class="input-group">
                             <button type="submit" class="btn btn-primary" >Ajouter</button>
                            </div> 
                        </div>
                       
              
                      
            
          </form>
          
            <script src="assets/js/jquery.js"></script>
            <script src="assets/js/bootstrap.min.js"></script>
  
    </body>
</html>
