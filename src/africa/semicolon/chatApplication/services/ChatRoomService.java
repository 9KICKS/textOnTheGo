package africa.semicolon.chatApplication.services;

import africa.semicolon.chatApplication.data.models.ChatRoom;
import africa.semicolon.chatApplication.data.models.Text;
import africa.semicolon.chatApplication.data.models.User;

public interface ChatRoomService {
    ChatRoom getChatRoom();
    void addUserToChatRoom(User user);
    void removeUserFromChatRoom(User user);
    void addTextToChatRoom(Text text);
}