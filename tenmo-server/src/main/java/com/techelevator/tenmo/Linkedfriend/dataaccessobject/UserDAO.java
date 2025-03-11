package com.techelevator.tenmo.Linkedfriend.dataaccessobject;

import com.techelevator.tenmo.Linkedfriend.Model.*;

import java.util.List;

public interface UserDAO {
    User getMeMyMoney(User askingForHelp);
    boolean gotGetGyat(Confirmation confirmation);

    boolean goodToGo(Confirmation confirmation);

    boolean makePreference(Preference onePreference);

    List<CombineUserCombine> basedOnYourUser(int id);

    CombineUserCombine needUser(UserLog oneUser);

    boolean thatMean(LikedUser userMatched) ;

    List<MatchComplete> allUser(int id);

    MatchComplete getUserOne(int userId,int id);

    List<Message> alongToBe(int matchId);

    boolean insertMessage(Message messageNice, int id);
    Preference getPref(int id);
    List<MatchComplete> userCompleteMatch(int id);
    List<MessageRead> signAlong(int id);




}
