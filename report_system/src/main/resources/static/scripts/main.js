$(document).ready(function() {
    function notify(title, content) {
        var notificationClone = $("#templateNotification").clone();
        notificationClone.addClass("notification");
        notificationClone.find(".toast-title").html(title);
        var today = new Date();
        var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
        notificationClone.find(".toast-time").html(time);
        // notificationClone.find(".toast-body").html(content);

        $("#notifications").append(notificationClone);
        $(".notification").toast("show");
    }

    notify("You have a new assignment!");
});
