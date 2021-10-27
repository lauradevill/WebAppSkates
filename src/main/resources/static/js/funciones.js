//SELECT URL according to the table name for GETTING information
function urlGetAll(tableName){
    urlSelected="";
    if (tableName=="skate"){
        urlSelected="http://150.230.86.149:80/api/Skate/all"
    }else if (tableName=="category"){
        urlSelected="http://150.230.86.149:80/api/Category/all"
    }else if (tableName=="client"){
        urlSelected="http://150.230.86.149:80/api/Client/all"
    }else if (tableName=="message"){
        urlSelected="http://150.230.86.149:80/api/Message/all"
    }else if (tableName=="reservation"){
        urlSelected="http://150.230.86.149:80/api/Reservation/all"
    }else if (tableName=="score"){
        urlSelected="http://150.230.86.149:80/api/Score/all"
    }else if (tableName=="admin"){
        urlSelected="http://150.230.86.149:80/api/Admin/all"
    }
    return urlSelected;
}
//SELECT URL according to the table name for SAVING information
function urlSave(tableName){
    urlSelected="";
    if (tableName=="skate"){
        urlSelected="http://150.230.86.149:80/api/Skate/save"
    }else if (tableName=="category"){
        urlSelected="http://150.230.86.149:80/api/Category/save"
    }else if (tableName=="client"){
        urlSelected="http://150.230.86.149:80/api/Client/save"
    }else if (tableName=="message"){
        urlSelected="http://150.230.86.149:80/api/Message/save"
    }else if (tableName=="reservation"){
        urlSelected="http://150.230.86.149:80/api/Reservation/save"
    }else if (tableName=="score"){
        urlSelected="http://150.230.86.149:80/api/Score/save"
    }else if (tableName=="admin"){
        urlSelected="http://150.230.86.149:80/api/Admin/save"
    }
    return urlSelected;
}
//SELECT URL according to the table name for EDITING information
function urlEdit(tableName){
    urlSelected="";
    if (tableName=="skate"){
        urlSelected="http:150.230.86.149:80/api/Skate/update"
    }else if (tableName=="category"){
        urlSelected="http://150.230.86.149:80/api/Category/update"
    }else if (tableName=="client"){
        urlSelected="http://150.230.86.149:80/api/Client/update"
    }else if (tableName=="message"){
        urlSelected="http://150.230.86.149:80/api/Message/update"
    }else if (tableName=="reservation"){
        urlSelected="http://150.230.86.149:80/api/Reservation/update"
    }else if (tableName=="score"){
        urlSelected="http://150.230.86.149:80/api/Score/update"
    }else if (tableName=="admin"){
        urlSelected="http://150.230.86.149:80/api/Admin/update"
    }
    return urlSelected;
}
//This Function allows to CLEAR FIELDS on the table space and input fields
function clearFields(tableName){
    if (tableName=="skate"){     
        $("#resultSkate").empty();  
        $("#idSkate").val(""); 
        $("#brandSkate").val("");
        $("#nameSkate").val("");
        $("#yearSkate").val("");
        $("#descriptionSkate").val("");
        $("#categorySkate").val("");
    }else if (tableName=="category"){
        $("#resultCategory").empty();
        $("#nameCategory").val("");
        $("#descriptionCategory").val("");
    }else if (tableName=="client"){
        $("#resultClient").empty();
        $("#nameClient").val("");
        $("#emailClient").val("");
        $("#ageClient").val("");
        $("#passwordClient").val("");
    }else if (tableName=="message"){
        $("#resultMessage").empty();
        $("#messageText").val("");
    }else if (tableName=="reservation"){
        $("#resultReservation").empty();
        $("#startDateReservation").val("");
        $("#devolutionDateReservation").val("");
    }else if (tableName=="score"){
        $("#resultScore").empty();
        $("#numberScore").val("");
        $("#messageScore").val("");
    }else if (tableName=="admin"){
        $("#resultAdmin").empty();
        $("#nameAdmin").val("");
        $("#emailAdmin").val("");
        $("#passwordAdmin").val("");
    }
}
//GET information from the server
function showData(tableName){
    if (tableName=="skate"){
        $.ajax({
            url:urlGetAll(tableName),
            type:"GET",
            datatype:"JSON",
            success:function(answer){
                console.log(answer);
                clearFields(tableName);
                paintAnswer(tableName,answer);
            }
        }); 
    }else if (tableName=="category"){
        $.ajax({
            url:urlGetAll(tableName),
            type:"GET",
            datatype:"JSON",
            success:function(answer){
                console.log(answer);
                clearFields(tableName);
                paintAnswer(tableName,answer);
            }
        }); 
    }else if (tableName=="client"){
        $.ajax({
            url:urlGetAll(tableName),
            type:"GET",
            datatype:"JSON",
            success:function(answer){
                console.log(answer);
                clearFields(tableName);
                paintAnswer(tableName,answer);
            }
        });
    }else if (tableName=="message"){
        $.ajax({
            url:urlGetAll(tableName),
            type:"GET",
            datatype:"JSON",
            success:function(answer){
                console.log(answer);
                clearFields(tableName);
                paintAnswer(tableName,answer);
            }
        }); 
    }else if (tableName=="reservation"){
        $.ajax({
            url:urlGetAll(tableName),
            type:"GET",
            datatype:"JSON",
            success:function(answer){
                console.log(answer);
                clearFields(tableName);
                paintAnswer(tableName,answer);
            }
        });
    }else if (tableName=="score"){
        $.ajax({
            url:urlGetAll(tableName),
            type:"GET",
            datatype:"JSON",
            success:function(answer){
                console.log(answer);
                clearFields(tableName);
                paintAnswer(tableName,answer);
            }
        });
    }else if (tableName=="admin"){
        $.ajax({
            url:urlGetAll(tableName),
            type:"GET",
            datatype:"JSON",
            success:function(answer){
                console.log(answer);
                clearFields(tableName);
                paintAnswer(tableName,answer);
            }
        });
    }
}
//SHOW INFORMATION brought from backend in a table in the frontend
function paintAnswer(tableName,items){
    let myTable="<table>";
    if (tableName=="skate"){
        for(i=0;i<items.length;i++){
            myTable+="<tr>";
            //myTable+="<td>"+items[i].id+"</td>";
            myTable+="<td>"+items[i].name+"</td>";
            myTable+="<td>"+items[i].brand+"</td>";
            myTable+="<td>"+items[i].year+"</td>";
            myTable+="<td>"+items[i].description+"</td>";
            myTable+="<td> <button onclick='editData(\"skate\","+items[i].id+")'>Actualizar</button>";
            myTable+="<td> <button onclick='deleteData(\"skate\","+items[i].id+")'>Borrar</button>";
            myTable+="</tr>";   
        }
        myTable+="</table>"; 
        $("#resultSkate").append(myTable);
        alert("Para actualizar: ingrese los nuevos valores en los campos y luego click en actualizar")
    }
    else if (tableName=="category"){
        $("#resultCategory").empty();
        for(i=0;i<items.length;i++){
            myTable+="<tr>";
            myTable+="<td>"+items[i].name+"</td>";
            myTable+="<td>"+items[i].description+"</td>";
            myTable+="<td> <button onclick='editData(\"category\","+items[i].id+")'>Actualizar</button>";
            myTable+="<td> <button onclick='deleteData(\"category\","+items[i].id+")'>Borrar</button>";
            myTable+="</tr>";   
        }
        myTable+="</table>";
        $("#resultCategory").append(myTable);
        alert("Para actualizar: ingrese los nuevos valores en los campos y luego click en actualizar")
    }
    else if (tableName=="client"){
        $("#resultClient").empty();
        for(i=0;i<items.length;i++){
            myTable+="<tr>";
            myTable+="<td>"+items[i].name+"</td>";
            myTable+="<td>"+items[i].email+"</td>";
            myTable+="<td>"+items[i].age+"</td>";
            myTable+="<td> <button onclick='editData(\"client\","+items[i].idClient+")'>Actualizar</button>";
            myTable+="<td> <button onclick='deleteData(\"client\","+items[i].idClient+")'>Borrar</button>";
            myTable+="</tr>";   
        }
        myTable+="</table>";
        $("#resultClient").append(myTable);
        alert("Para actualizar: ingrese los nuevos valores en los campos y luego click en actualizar")
    }
    else if (tableName=="message"){
        $("#resultMessage").empty();
        for(i=0;i<items.length;i++){
            myTable+="<tr>";
            myTable+="<td>"+items[i].messageText+"</td>";
            myTable+="<td> <button onclick='editData(\"message\","+items[i].idMessage+")'>Actualizar</button>";
            myTable+="<td> <button onclick='deleteData(\"message\","+items[i].idMessage+")'>Borrar</button>";
            myTable+="</tr>";   
        }
        myTable+="</table>";
        $("#resultMessage").append(myTable);
        alert("Para actualizar: ingrese los nuevos valores en los campos y luego click en actualizar")
    }
    else if (tableName=="reservation"){
        $("#resultReservation").empty();
        for(i=0;i<items.length;i++){
            myTable+="<tr>";
            myTable+="<td>"+items[i].startDate+"</td>";
            myTable+="<td>"+items[i].devolutionDate+"</td>";
            myTable+="<td>"+items[i].status+"</td>";
            myTable+="<td> <button onclick='editData(\"reservation\","+items[i].idReservation+")'>Actualizar</button>";
            myTable+="<td> <button onclick='deleteData(\"reservation\","+items[i].idReservation+")'>Borrar</button>";
            myTable+="</tr>";   
        }
        myTable+="</table>";
        $("#resultReservation").append(myTable);
        alert("Para actualizar: ingrese los nuevos valores en los campos y luego click en actualizar")
    }
    else if (tableName=="score"){
        $("#resultScore").empty();
        for(i=0;i<items.length;i++){
            myTable+="<tr>";
            myTable+="<td>"+items[i].number+"</td>";
            myTable+="<td>"+items[i].messageScore+"</td>";
            myTable+="<td> <button onclick='editData(\"score\","+items[i].idScore+")'>Actualizar</button>";
            myTable+="<td> <button onclick='deleteData(\"score\","+items[i].idScore+")'>Borrar</button>";
            myTable+="</tr>";   
        }
        myTable+="</table>";
        $("#resultScore").append(myTable);
        alert("Para actualizar: ingrese los nuevos valores en los campos y luego click en actualizar")
    }
    else if (tableName=="admin"){
        $("#resultAdmin").empty();
        for(i=0;i<items.length;i++){
            myTable+="<tr>";
            myTable+="<td>"+items[i].nameAdmin+"</td>";
            myTable+="<td>"+items[i].emailAdmin+"</td>";
            myTable+="<td> <button onclick='editData(\"admin\","+items[i].idAdmin+")'>Actualizar</button>";
            myTable+="<td> <button onclick='deleteData(\"admin\","+items[i].idAdmin+")'>Borrar</button>";
            myTable+="</tr>";   
        }
        myTable+="</table>";
        $("#resultAdmin").append(myTable);
        alert("Para actualizar: ingrese los nuevos valores en los campos y luego click en actualizar")
    }
}
//SAVE INFORMATION on the backend
function saveData(tableName){
    if (tableName=="skate"){
            let myData={
                brand:$("#brandSkate").val(),
                name:$("#nameSkate").val(),
                year:$("#yearSkate").val(),
                description:$("#descriptionSkate").val(),
                //category:{id:$("#categorySkate").val()}
            };
            let dataToSend=JSON.stringify(myData);
            $.ajax({
                url:urlSave(tableName),
                type:"POST",
                data:dataToSend,
                contentType:"application/json; charset=utf-8",
                datatype:"JSON",
                success:function(answer){
                    showData(tableName);
                    alert("se ha guardado con éxito");
                    clearFields(tableName);
                }
            });
    }else if (tableName=="category"){
        let myData={
            name:$("#nameCategory").val(),
            description:$("#descriptionCategory").val(),
        };
        let dataToSend=JSON.stringify(myData);
        $.ajax({
            url:urlSave(tableName),
            type:"POST",
            data:dataToSend,
            contentType:"application/json; charset=utf-8",
            datatype:"JSON",
            success:function(answer){
                showData(tableName);
                alert("se ha guardado con éxito");
                clearFields(tableName);
            }
        });
    }else if (tableName=="client"){
        let myData={
            name:$("#nameClient").val(),
            email:$("#emailClient").val(),
            age:$("#ageClient").val(),
            password:$("#passwordClient").val(),
        };
        let dataToSend=JSON.stringify(myData);
        $.ajax({
            url:urlSave(tableName),
            type:"POST",
            data:dataToSend,
            contentType:"application/json; charset=utf-8",
            datatype:"JSON",
            success:function(answer){
                showData(tableName);
                alert("se ha guardado con éxito");
                clearFields(tableName);
            }
        });
    }else if (tableName=="message"){
        let myData={
            messageText:$("#messageText").val(),
        };
        let dataToSend=JSON.stringify(myData);
        $.ajax({
            url:urlSave(tableName),
            type:"POST",
            data:dataToSend,
            contentType:"application/json; charset=utf-8",
            datatype:"JSON",
            success:function(answer){
                showData(tableName);
                alert("se ha guardado con éxito");
                clearFields(tableName);
            }
        });
    }else if (tableName=="reservation"){
        let myData={
            startDate:$("#startDateReservation").val(),
            devolutionDate:$("#devolutionDateReservation").val(),
            status:$("#status").val(),
        };
        let dataToSend=JSON.stringify(myData);
        $.ajax({
            url:urlSave(tableName),
            type:"POST",
            data:dataToSend,
            contentType:"application/json; charset=utf-8",
            datatype:"JSON",
            success:function(answer){
                showData(tableName);
                alert("se ha guardado con éxito");
                clearFields(tableName);
            }
        });
    }
    else if (tableName=="score"){
        let myData={
            number:$("#numberScore").val(),
            messageScore:$("#messageScore").val(),
        };
        let dataToSend=JSON.stringify(myData);
        $.ajax({
            url:urlSave(tableName),
            type:"POST",
            data:dataToSend,
            contentType:"application/json; charset=utf-8",
            datatype:"JSON",
            success:function(answer){
                showData(tableName);
                alert("se ha guardado con éxito");
                clearFields(tableName);
            }
        });
    }
    else if (tableName=="admin"){
        let myData={
            nameAdmin:$("#nameAdmin").val(),
            emailAdmin:$("#emailAdmin").val(),
            passwordAdmin:$("#passwordAdmin").val(),
        };
        let dataToSend=JSON.stringify(myData);
        $.ajax({
            url:urlSave(tableName),
            type:"POST",
            data:dataToSend,
            contentType:"application/json; charset=utf-8",
            datatype:"JSON",
            success:function(answer){
                showData(tableName);
                alert("se ha guardado con éxito");
                clearFields(tableName);
            }
        });
    }
}
//SEND EDIT INFOMATION to the backend
function editData(tableName,idElement){
    if (tableName=="skate"){
        let myData={
            id:idElement,
            brand:$("#brandSkate").val(),
            name:$("#nameSkate").val(),
            year:$("#yearSkate").val(),
            description:$("#descriptionSkate").val(),
        };
        let dataToSend=JSON.stringify(myData);
        $.ajax({
            url:urlEdit(tableName),
            type:"PUT",
            data:dataToSend,
            contentType:"application/json; charset=utf-8",
            datatype:"JSON",
            success:function(answer){
                showData(tableName);
                alert("se ha actualizado con éxito");
                clearFields(tableName);
            }
        });
    }else if (tableName=="category"){
        let myData={
            id:idElement,
            name:$("#nameCategory").val(),
            description:$("#descriptionCategory").val(),
        };
        let dataToSend=JSON.stringify(myData);
        $.ajax({
            url:urlEdit(tableName),
            type:"PUT",
            data:dataToSend,
            contentType:"application/json; charset=utf-8",
            datatype:"JSON",
            success:function(answer){
                showData(tableName);
                alert("se ha actualizado con éxito");
                clearFields(tableName);
            }
        });
    }else if (tableName=="client"){
        let myData={
            idClient:idElement,
            name:$("#nameClient").val(),
            email:$("#emailClient").val(),
            age:$("#ageClient").val(),
            password:$("#passwordClient").val(),
        };
        let dataToSend=JSON.stringify(myData);
        $.ajax({
            url:urlEdit(tableName),
            type:"PUT",
            data:dataToSend,
            contentType:"application/json; charset=utf-8",
            datatype:"JSON",
            success:function(answer){
                showData(tableName);
                alert("se ha actualizado con éxito");
                clearFields(tableName);
            }
        });
    }else if (tableName=="message"){
        let myData={
            idMessage:idElement,
            messageText:$("#messageText").val(),
        };
        let dataToSend=JSON.stringify(myData);
        $.ajax({
            url:urlEdit(tableName),
            type:"PUT",
            data:dataToSend,
            contentType:"application/json; charset=utf-8",
            datatype:"JSON",
            success:function(answer){
                showData(tableName);
                alert("se ha actualizado con éxito");
                clearFields(tableName);
            }
        });
    }else if (tableName=="reservation"){
        let myData={
            idReservation:idElement,
            startDate:$("#startDateReservation").val(),
            devolutionDate:$("#devolutionDateReservation").val(),
        };
        let dataToSend=JSON.stringify(myData);
        $.ajax({
            url:urlEdit(tableName),
            type:"PUT",
            data:dataToSend,
            contentType:"application/json; charset=utf-8",
            datatype:"JSON",
            success:function(answer){
                showData(tableName);
                alert("se ha actualizado con éxito");
                clearFields(tableName);
            }
        });
    }else if (tableName=="score"){
        let myData={
            idScore:idElement,
            number:$("#numberScore").val(),
            messageScore:$("#messageScore").val(),
        };
        let dataToSend=JSON.stringify(myData);
        $.ajax({
            url:urlEdit(tableName),
            type:"PUT",
            data:dataToSend,
            contentType:"application/json; charset=utf-8",
            datatype:"JSON",
            success:function(answer){
                showData(tableName);
                alert("se ha actualizado con éxito");
                clearFields(tableName);
            }
        });
    }else if (tableName=="admin"){
        let myData={
            idAdmin:idElement,
            nameAdmin:$("#nameAdmin").val(),
            emailAdmin:$("#emailAdmin").val(),
            passwordAdmin:$("#passwordAdmin").val(),
        };
        let dataToSend=JSON.stringify(myData);
        $.ajax({
            url:urlEdit(tableName),
            type:"PUT",
            data:dataToSend,
            contentType:"application/json; charset=utf-8",
            datatype:"JSON",
            success:function(answer){
                showData(tableName);
                alert("se ha actualizado con éxito");
                clearFields(tableName);
            }
        });
    }
}
//Delete Data on the backend
function deleteData(tableName,idElement){
    if (tableName=="skate"){
        let myData={
            id:idElement
        };
        let id=idElement;
        let dataToSend=JSON.stringify(myData);
        $.ajax({
            url:"http://150.230.86.149:80/api/Skate/"+id+"",
            type:"DELETE",
            data:dataToSend,
            contentType:"application/json; charset=utf-8",
            datatype:"JSON",
            success:function(answer){
                clearFields(tableName);
                showData(tableName);
                alert("se ha borrado con éxito");                
            }  
        });
    }else if (tableName=="category"){
        let myData={
            id:idElement
        };
        let id=idElement;
        let dataToSend=JSON.stringify(myData);
        $.ajax({
            url:"http://150.230.86.149:80/api/Category/"+id+"",
            type:"DELETE",
            data:dataToSend,
            contentType:"application/json; charset=utf-8",
            datatype:"JSON",
            success:function(answer){
                clearFields(tableName);
                showData(tableName);
                alert("se ha borrado con éxito");                
            }  
        });
    }else if (tableName=="client"){
        let myData={
            id:idElement
        };
        let id=idElement;
        let dataToSend=JSON.stringify(myData);
        $.ajax({
            url:"http://150.230.86.149:80/api/Client/"+id+"",
            type:"DELETE",
            data:dataToSend,
            contentType:"application/json; charset=utf-8",
            datatype:"JSON",
            success:function(answer){
                clearFields(tableName);
                showData(tableName);
                alert("se ha borrado con éxito");                
            }  
        });
    }else if (tableName=="message"){
        let myData={
            id:idElement
        };
        let id=idElement;
        let dataToSend=JSON.stringify(myData);
        $.ajax({
            url:"http://150.230.86.149:80/api/Message/"+id+"",
            type:"DELETE",
            data:dataToSend,
            contentType:"application/json; charset=utf-8",
            datatype:"JSON",
            success:function(answer){
                clearFields(tableName);
                showData(tableName);
                alert("se ha borrado con éxito");                
            }  
        });
    }else if (tableName=="reservation"){
        let myData={
            id:idElement
        };
        let id=idElement;
        let dataToSend=JSON.stringify(myData);
        $.ajax({
            url:"http://150.230.86.149:80/api/Reservation/"+id+"",
            type:"DELETE",
            data:dataToSend,
            contentType:"application/json; charset=utf-8",
            datatype:"JSON",
            success:function(answer){
                clearFields(tableName);
                showData(tableName);
                alert("se ha borrado con éxito");                
            }  
        });
    }else if (tableName=="score"){
        let myData={
            id:idElement
        };
        let id=idElement;
        let dataToSend=JSON.stringify(myData);
        $.ajax({
            url:"http://150.230.86.149:80/api/Score/"+id+"",
            type:"DELETE",
            data:dataToSend,
            contentType:"application/json; charset=utf-8",
            datatype:"JSON",
            success:function(answer){
                clearFields(tableName);
                showData(tableName);
                alert("se ha borrado con éxito");                
            }  
        });
    }
    else if (tableName=="admin"){
        let myData={
            id:idElement
        };
        let id=idElement;
        let dataToSend=JSON.stringify(myData);
        $.ajax({
            url:"http://150.230.86.149:80/api/Admin/"+id+"",
            type:"DELETE",
            data:dataToSend,
            contentType:"application/json; charset=utf-8",
            datatype:"JSON",
            success:function(answer){
                clearFields(tableName);
                showData(tableName);
                alert("se ha borrado con éxito");                
            }  
        });
    }
}

//<input type="text" id="status" placeholder="Estado" required>