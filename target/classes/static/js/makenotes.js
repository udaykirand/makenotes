function create() {
	document.getElementById("create").style.display = 'block';
	document.getElementById("list").style.display = 'none';
	document.getElementById("noteHead").style.display = 'none';
	document.getElementById("noteBody").style.display = 'none';
}

function submitNotes() {
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "/makenotes/api/v1",
		dataType : "json", // data type of response
		data : toJSON(),
		success : function(data, textStatus, jqXHR) {
			alert('Note created successfully');
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('error: ' + textStatus);
		}
	});
	resetNotes();
}

function resetNotes() {
	document.getElementById("header").value = 'Notes';
	document.getElementById("notesBody").value = '';
}

function list() {
	document.getElementById("list").style.display = 'block';
	document.getElementById("create").style.display = 'none';
	renderList();
}

function getAllNotes() {
	document.getElementById("list").style.display = 'block';
	document.getElementById("create").style.display = 'none';
	$.ajax({
		type : 'GET',
		url : "/makenotes/api/v1",
		contentType : 'application/json',
		dataType : "json", // data type of response
		success : function(data, textStatus, jqXHR) {
			var list = data == null ? [] : (data instanceof Array ? data
					: [ data ]);
			$('#notesList li').remove();
			$.each(list, function(index, notes) {
				$('#notesList').append(
						'<li><a href="#" onclick="javascript:getNotesWithId('
								+ notes.id + ')"">' + notes.header
								+ '</a></li>');
			});
		}
	});
}

function loadNotes() {
	$.ajax({
		type : 'GET',
		url : "/makenotes/api/v1",
		contentType : 'application/json',
		dataType : "json", // data type of response
		success : function(data, textStatus, jqXHR) {
			var list = data == null ? [] : (data instanceof Array ? data
					: [ data ]);
			$('#notesList li').remove();
			$.each(list, function(index, notes) {
				$('#notesList').append(
						'<li><a href="#" onclick="javascript:deleteNotes('
								+ notes.id + ')"">' + notes.header
								+ '</a></li>');
			});
		}
	});
	document.getElementById("create").style.display = 'none';
	document.getElementById("list").style.display = 'block';
	document.getElementById("noteHead").style.display = 'none';
	document.getElementById("noteBody").style.display = 'none';
}

function getNotesWithId(id) {
	var url = "/makenotes/api/v1/" + id
	$.ajax({
		type : 'GET',
		url : url,
		contentType : 'application/json',
		dataType : "json", // data type of response
		success : function(data, textStatus, jqXHR) {
			document.getElementById('noteHead').style.display = 'block';
			document.getElementById('noteBody').style.display = 'block';
			$('#noteHead').html(data.data.header);
			$('#noteBody').html(data.data.notesBody);
		}
	});
}

function deleteNotes(id) {
	var isDel = confirm("Are you sure want to delete?");
	if (isDel) {
		var url = "/makenotes/api/v1/" + id
		$.ajax({
			type : 'DELETE',
			url : url,
			contentType : 'application/json',
			dataType : "json", // data type of response
			success : function(data, textStatus, jqXHR) {
				getAllNotes();
			}
		});
	}
}

function toJSON() {
	return JSON.stringify({
		"header" : $('#header').val(),
		"notesBody" : $('#notesBody').val()
	});
}