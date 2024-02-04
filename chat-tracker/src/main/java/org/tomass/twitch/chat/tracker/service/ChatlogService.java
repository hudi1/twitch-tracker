package org.tomass.twitch.chat.tracker.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tomass.twitch.dao.ChatLogDao;
import org.tomass.twitch.model.ChatLog;

import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.chat.events.channel.IRCMessageEvent;

@Service
@Transactional(timeout = 60000)
public class ChatlogService {

    @Lazy
    @Autowired
    private TwitchClient client;

    @Autowired
    private ChatLogDao chatLogDao;

    public ChatLog createChatlog(ChatLog chatlog) {
        return chatLogDao.insert(chatlog);
    }

    public ChatLog getChatlog(String eventId) {
        return chatLogDao.get(new ChatLog().withEventId(eventId));
    }

    public int updateChatlog(ChatLog ChatLog) {
        return chatLogDao.update(ChatLog);
    }

    public int deleteChatlog(ChatLog ChatLog) {
        return chatLogDao.delete(ChatLog);
    }

    public List<ChatLog> listChatlog(ChatLog ChatLog) {
        return chatLogDao.list(ChatLog);
    }

    public void ulozChatlog(IRCMessageEvent event) {
        ChatLog chatlog = new ChatLog();
        chatlog.setEventId(event.getEventId());
        chatlog.setChannel(event.getChannelName().get());
        chatlog.setUser(event.getUserName());
        chatlog.setChannelId(Long.valueOf(event.getChannelId()));
        chatlog.setUserId(Long.valueOf(event.getUserId()));
        chatlog.setMessage(event.getMessage().get());
        // chatlog.setStreamId(1);
        chatlog.setTs(LocalDateTime.now());
        chatlog.setFireAt(LocalDateTime.ofInstant(event.getFiredAtInstant(), ZoneId.of("Europe/Prague")));
        if (event.getTagValue("color").isPresent()) {
            chatlog.setColor(event.getTagValue("color").get());
        }
        if (event.getSubscriberMonths().isPresent()) {
            chatlog.setSubsMonths(event.getSubscriberMonths().getAsInt());
        }
        if (event.getSubscriptionTier().isPresent()) {
            chatlog.setSubsTier(event.getSubscriptionTier().getAsInt());
        }
        createChatlog(chatlog);
    }

}