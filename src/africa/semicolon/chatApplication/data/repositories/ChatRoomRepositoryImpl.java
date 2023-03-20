package africa.semicolon.chatApplication.data.repositories;

import africa.semicolon.chatApplication.data.models.ChatRoom;
import africa.semicolon.chatApplication.data.models.Text;
import africa.semicolon.chatApplication.data.models.User;

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