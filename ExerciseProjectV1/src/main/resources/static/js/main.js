/**
 * this code equips the edit- and delete-buttons with modals and functionality,
 * also fills the edit-modal with attributes of the specific cocktail. Gives functonality the the
 * "scroll to the top"-button (on-click function in actual HTML-file)
 */

$(document).ready(function() {
	$('.table .editButton').on('click', function(event) {
		event.preventDefault();

		var href = $(this).attr('href');
		$.get(href, function(cocktail) {
			$('#idEdit').val(cocktail.id);
			$('#nameEdit').val(cocktail.name);
			$('#messageEdit').val(cocktail.message);
			$('#pictureEdit').val(cocktail.picture);
		})

		$('#editModal').modal();
	});

	$('.table .deleteButton').on('click', function(event) {
		event.preventDefault();

		var href = $(this).attr('href');
		$('#deleteModal #deleteId').attr('href', href);
		$('#deleteModal').modal();
	});

	scrollButton = document.getElementById("scrollBtn");
	window.onscroll = function() { scrollFunction() };

	function scrollFunction() {
		if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
			scrollButton.style.display = "block";
		} else {
			scrollButton.style.display = "none";
		}
	}

});