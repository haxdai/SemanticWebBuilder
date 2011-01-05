package org.semanticwb.mask;

import java.util.Iterator;
import org.semanticwb.model.SWBModel;
import org.semanticwb.model.User;

public class Friendship extends org.semanticwb.mask.base.FriendshipBase
{
    public Friendship(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public static boolean areFriends(User user1, User user2, SWBModel model) {
        Iterator<Friendship> itMyFriends = Friendship.ClassMgr.listFriendshipByFriend(user1, model);
        while (itMyFriends.hasNext()) {
            Friendship friendShip = itMyFriends.next();
            Iterator<User> itfriendUser = friendShip.listFriends();
            while (itfriendUser.hasNext()) {
                User friendUser = itfriendUser.next();
                if (friendUser.getURI().equals(user2.getURI())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int myFriends(User user1, SWBModel model) {
        int cont=0;
        Iterator<Friendship> itMyFriends = Friendship.ClassMgr.listFriendshipByFriend(user1, model);
        while (itMyFriends.hasNext()) {
            itMyFriends.next();
            cont++;
        }
        return cont;
    }

    public static boolean removeFriendRelationShip(User user1, User user2, SWBModel model) {
        Iterator<Friendship> itMyFriends = Friendship.ClassMgr.listFriendshipByFriend(user1, model);
        while (itMyFriends.hasNext()) {
            Friendship friendShip = itMyFriends.next();
            Iterator<User> itfriendUser = friendShip.listFriends();
            while (itfriendUser.hasNext()) {
                User friendUser = itfriendUser.next();
                if (friendUser.getURI().equals(user2.getURI())) {
                    friendShip.remove();
                    return true;
                }
            }
        }
        return false;
    }
}

