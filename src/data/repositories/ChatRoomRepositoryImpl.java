package data.repositories;

import data.models.ChatRoom;
import data.models.Text;
import data.models.User;

import java.util.List;

public class ChatRoomRepositoryImpl implements ChatRoomRepository {
    private final ChatRoom chatRoom;

    public ChatRoomRepositoryImpl(List<User> users, List<Text> texts) {
        this.chatRoom = new ChatRoom(users, texts);
    }

    @Override
    public ChatRoom getChatRoom() {
        return this.chatRoom;
    }
}