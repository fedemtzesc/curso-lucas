// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarUsuarios();

    $('#usuarios').DataTable();
});


async function cargarUsuarios(){
       const usersRequest = await fetch('api/usuarios', {

        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        //body: JSON.stringify({a: 1, b: 'Textual content'})
      });
      const usersResponse = await usersRequest.json();

      console.log(usersResponse);

      let resultHTML = '';
      document.querySelector('#usuarios tbody').innerHTML = '';
      for(let usr of usersResponse){
          let tmpHTML='';
          tmpHTML += '<tr>';
          tmpHTML += '<td>'+usr.id+'</td>';
          tmpHTML += '<td>'+usr.nombre+' '+usr.apellido+'</td>';
          tmpHTML += '<td>'+usr.email+'</td>';
          tmpHTML += '<td>'+usr.telefono+'</td>';
          tmpHTML += '<td>';
          tmpHTML += '<a href="#" onclick="eliminarUsuario('+usr.id+')" class="btn btn-danger btn-circle btn-sm">';
          tmpHTML += '<i class="fas fa-trash"></i>';
          tmpHTML += '</a>';
          tmpHTML += '</td>';
          tmpHTML += '</tr>\n';
          resultHTML += tmpHTML;
      }
      document.querySelector('#usuarios tbody').innerHTML = resultHTML;
}

async function eliminarUsuario(id){
    if(!confirm("Desea eliminar a este usuario?")){
        return;
    }

    const request = await fetch('api/usuarios/' + id, {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    //body: JSON.stringify({a: 1, b: 'Textual content'})
  });

    location.reload();

}