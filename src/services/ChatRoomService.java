package services;

import data.models.ChatRoom;
import data.models.Text;
import data.models.User;

public interface ChatRoomService {
    ChatRoom getChatRoom();
    void addUserToChatRoom(User user);
    void removeUserFromChatRoom(User user);
    void addTextToChatRoom(Text text);
}