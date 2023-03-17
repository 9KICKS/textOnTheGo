package services;

import data.models.ChatRoom;
import data.models.Text;
import data.models.User;
import data.repositories.ChatRoomRepository;
import data.repositories.TextRepository;
import data.repositories.UserRepository;

public class ChatRoomServiceImpl implements ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;
    private final UserRepository userRepository;
    private final TextRepository textRepository;

    public ChatRoomServiceImpl(ChatRoomRepository chatRoomRepository, UserRepository userRepository, TextRepository textRepository) {
        this.chatRoomRepository = chatRoomRepository;
        this.userRepository = userRepository;
        this.textRepository = textRepository;
    }

    @Override
    public ChatRoom getChatRoom() {
        return chatRoomRepository.getChatRoom();
    }

    @Override
    public void addUserToChatRoom(User user) {
        ChatRoom chatRoom = chatRoomRepository.getChatRoom();
        chatRoom.addUser(user);
    }

    @Override
    public void removeUserFromChatRoom(User user) {
        ChatRoom chatRoom = chatRoomRepository.getChatRoom();
        chatRoom.removeUser(user);
    }

    @Override
    public void addTextToChatRoom(Text text) {
        textRepository.addText(text);
    }
}