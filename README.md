# SocketChat

This is meant to run multiple instances AFTER the server-side is running.

After entering their username, users can add groups and join them. Messages are sent only to other members of the group that they sent the chat from. Each unique user-group pair creates a socket to connect to a singular server.

Internally, after creating a group, the username and group is sent to the server to uniquely identify the client.

The default code only works locally. To alter the IP (hostname) and PORT, you must change 'hostname' and 'port' in the ChatClient class in this code AND change the 'port' variable in the ChatServer class of the server-side code. (A different repository) You'll have to change the hostname to match the external IP of the computer that is running the server-side code.