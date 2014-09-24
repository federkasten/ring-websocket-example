(function() {
    var start = function () {
        var socket = new WebSocket("ws://" + window.location.host + window.location.pathname + "echo/");

        var messageBox = document.getElementById("message");

        socket.onmessage = function (event) {
            var msg = document.createElement("p");
            msg.appendChild(document.createTextNode(event.data));

            messageBox.insertBefore(msg, messageBox.children[0]);
        };

        socket.onopen = function (event) {
            var sendText = document.getElementById("send-text");
            var sendButton = document.getElementById("send-button");

            sendButton.addEventListener("click", function(e) {
                var text = sendText.value;

                if (text.length > 0) {
                    socket.send(text);
                    sendText.value = "";
                }
            });
        };
    };

    window.onload = start;
}());
