# upnp-dlna-player
This project is a first alpha approach to write a simple media player, which is using upnp-dlna. This project is using Swing for UI.

##What's working (most of the time)
- Drag and drop local files into the playlist, also recursive - for playlist entry name the file name is used.
- Select playlist entries and delete them with key DEL, CTRL+A also works
- Play, Pause selected playlist entry
- Volume Up/Down
- Paste (CTRL+V) a url from clipboard

##What's planned
- Make stable

##Install and Usage
```bash
git clone https://github.com/neocdtv/streamingservice
cd streamingservice
mvn clean install
git clone https://github.com/neocdtv/upnp-dlna-player
cd upnp-dlna-player
mvn clean install
java -jar target/upnp-dlna-player-0.2-jar-with-dependencies.jar 
```


