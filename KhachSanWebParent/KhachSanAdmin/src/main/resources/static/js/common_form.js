$(document).ready(function () {
    $("#customFile").change(function () {
        fileSize = this.files[0].size;
        if (fileSize > 5242880) {
            this.setCustomValidity("You must choose an image less than 5MB");
            this.reportValidity();
            showImageThumbnail("");
        } else {
            this.setCustomValidity("");
            showImageThumbnail(this);
        }
    });
})
function showImageThumbnail(fileInput) {
    var file = fileInput.files[0];
    var reader = new FileReader();
    reader.onload = function (e) {
        $("#thumbnail").attr("src", e.target.result);
    }
    reader.readAsDataURL(file);
}