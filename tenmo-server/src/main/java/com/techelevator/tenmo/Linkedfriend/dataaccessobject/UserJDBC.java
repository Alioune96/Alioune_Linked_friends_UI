package com.techelevator.tenmo.Linkedfriend.dataaccessobject;

import com.techelevator.tenmo.Linkedfriend.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class UserJDBC  implements UserDAO{
    @Autowired
    private JdbcTemplate iCanFeel;


    @Override
    public User getMeMyMoney(User askingForHelp) {
        User notUser = new User();
        String iStealInfo = "INSERT INTO users (profile_picture, first_name, last_name, phone_number, email, password, age, gender,birth_date) VALUES (?,?,?,?,?,?,?,?,?) RETURNING user_id";
        int numberThatMakeMeSteal = iCanFeel.queryForObject(iStealInfo, int.class, askingForHelp.getProfilePicture(),askingForHelp.getFirstName(),askingForHelp.getLastName(),askingForHelp.getPhoneNumber(),askingForHelp.getEmail(),askingForHelp.getPassWord(),askingForHelp.getAge(),askingForHelp.getGender(),askingForHelp.getBirthDay());
        if(numberThatMakeMeSteal>0){
            String getUser = "SELECT * FROM users WHERE user_id = ?";
            SqlRowSet everyThing = iCanFeel.queryForRowSet(getUser, numberThatMakeMeSteal);
            if(!everyThing.wasNull()){
                if(everyThing.next()){
                    return iNeedUser(notUser, everyThing);
                }
            }
        }



        return notUser;
    }

    @Override
    public boolean gotGetGyat(Confirmation rockAndRoll) {
        iCanFeel.update("DELETE FROM confirmation WHERE phone_number = ?",rockAndRoll.getPhoneNumber());
        String insertNow = "INSERT INTO confirmation(phone_number, text_message) VALUES(?,?) RETURNING confirmation_id";
        int numberGreat = iCanFeel.queryForObject(insertNow,int.class,rockAndRoll.getPhoneNumber(),rockAndRoll.getTextMessage());
        if(numberGreat>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean goodToGo(Confirmation confirmation) {
        SqlRowSet tryMe = iCanFeel.queryForRowSet("SELECT * FROM confirmation WHERE phone_number = ? AND text_message = ?", confirmation.getPhoneNumber().substring(2), confirmation.getTextMessage());
            if (!tryMe.wasNull()) {
                if (tryMe.next()) {
                    return tryMe.getInt("confirmation_id") > 0 ? true: false;
                }
            }
        return false;
    }

    @Override
    public boolean makePreference(Preference onePreference) {
        String sqlValue = "INSERT INTO preference(user_id, relationship_status, hobbies) VALUES (?,?,?) RETURNING preference_id";
        String someOfThose= "";
        for (int i = 0; i <onePreference.getHobbies().length ; i++) {
            someOfThose+= i!=onePreference.getHobbies().length-1 ? onePreference.getHobbies()[i]+";": onePreference.getHobbies()[i];
        }

        int needNumberRun = iCanFeel.queryForObject(sqlValue,int.class ,onePreference.getUserId(), onePreference.getRelationshipStatus(),someOfThose);

        return needNumberRun > 0 ? true: false;
    }

    @Override
    public List<CombineUserCombine> basedOnYourUser(int id) {
        Preference oneNeed = null;
        String getUserHobbies = "SELECT * FROM preference WHERE user_id = ?";
        SqlRowSet oneLover = iCanFeel.queryForRowSet(getUserHobbies, id);
        if(!oneLover.wasNull()){
            if(oneLover.next()){
                oneNeed = iNeedYouRightNow(oneLover);
            }else{
                return null;
            }
        }


        List<Preference> thatNice = new ArrayList<>();
        String inTheRed = "SELECT * FROM preference WHERE user_id != ?";
        SqlRowSet completeWhat = iCanFeel.queryForRowSet(inTheRed, id);
        if(!completeWhat.wasNull()){
            while(completeWhat.next()){
                Preference forMe = iNeedYouRightNow(completeWhat);
                thatNice.add(forMe);
            }
        }
        List<CombineUserCombine> allCommon = new ArrayList<>();
        String[] thatAlot = oneNeed.getHobbies();
        String getOne = "SELECT * FROM users WHERE user_id = ?";
        String userPreference = "SELECT * FROM preference WHERE user_id = ? ";
        for (int i = 0; i <thatNice.size() ; i++) {
            String[] thatInstance = thatNice.get(i).getHobbies();
            int counterMe = 0;
            boolean toMake = false;
            for (int j = 0; j < thatAlot.length ; j++) {
                for (int k = 0; k <thatInstance.length ; k++) {
                    if(thatAlot[j].contains(thatInstance[k])){
                        counterMe+=1;
                        break;
                    }
                }
                if(counterMe>=1){
                    SqlRowSet getOneUser = iCanFeel.queryForRowSet(getOne, thatNice.get(i).getUserId());
                    SqlRowSet getUserPreference = iCanFeel.queryForRowSet(userPreference, thatNice.get(i).getUserId());
                    if(!getOneUser.wasNull() && !getUserPreference.wasNull()){
                        if(getOneUser.next() && getUserPreference.next()){
                            User cuzIWas = new User();
                            User oneCommon = iNeedUser(cuzIWas,getOneUser);
                            Preference niceEasy = iNeedYouRightNow(getUserPreference);
                            CombineUserCombine mentalSickNess = new CombineUserCombine();
                            mentalSickNess.setUserPreference(niceEasy);
                            mentalSickNess.setUserStuff(oneCommon);
                            if(!allCommon.contains(mentalSickNess)) {
                                allCommon.add(mentalSickNess);
                            }
                            toMake = true;
                        }
                    }
                }
                if(toMake){
                    break;
                }
            }

        }

        return allCommon;
    }

    @Override
    public CombineUserCombine needUser(UserLog oneUser) {
        CombineUserCombine thatMe = new CombineUserCombine();
        User userToGo = new User();
        Preference throughToMe = null;
        String getOneFromSql = "SELECT * FROM users WHERE email = ? AND password = ?";
        SqlRowSet resultedNeed =  iCanFeel.queryForRowSet(getOneFromSql, oneUser.getEmail(), oneUser.getPassword());
        if(!resultedNeed.wasNull()){
            if(resultedNeed.next()){
                userToGo = iNeedUser(userToGo,resultedNeed);
            }
        }
        SqlRowSet allThatMean = iCanFeel.queryForRowSet("SELECT * FROM preference WHERE user_id = ?", userToGo.getUserId());
        if(!allThatMean.wasNull()){
            if(allThatMean.next()){
                throughToMe = iNeedYouRightNow(allThatMean);
            }
        }
        thatMe.setUserStuff(userToGo);
        thatMe.setUserPreference(throughToMe);

        return thatMe;
    }

    @Override
    public boolean thatMean(LikedUser userMatched) {
        LikedUser oneTime = null;
        String differentSql = "SELECT * FROM liked_user WHERE f_user_id = ? AND s_user_id = ?";
        SqlRowSet oneThingAbout = iCanFeel.queryForRowSet(differentSql,userMatched.getSecondUserId(), userMatched.getFirstUserId());
        if(!oneThingAbout.wasNull()){
            if(oneThingAbout.next()){
                oneTime = oneLike(oneThingAbout);
            }
        }
        String enterSql = "INSERT INTO liked_user(f_user_id, s_user_id, liked_time) VALUES (?,?,?) RETURNING liked_id";
        int iWantToBe = iCanFeel.queryForObject(enterSql, int.class,userMatched.getFirstUserId(),userMatched.getSecondUserId(), userMatched.getLikedTime());
        if(oneTime != null){
            Preference thatFirst = getPref(userMatched.getFirstUserId());
            Preference thatSecond = getPref(userMatched.getSecondUserId());
            String[] lookLike = thatSecond.getHobbies();
            String[] secondLook = thatFirst.getHobbies();
            int numberToAdd = 0;
            for (int i = 0; i < lookLike.length; i++) {
                for (int j = 0; j < secondLook.length ; j++) {
                    if(lookLike[i].contains(secondLook[j])){
                        numberToAdd+=1;
                    }
                }
            }
            iCanFeel.update("INSERT INTO match_user(f_user_id,s_user_id,match_date, match_compatibility) VALUES(?,?,?,?)", userMatched.getFirstUserId(),userMatched.getSecondUserId(),LocalDate.now(), BigDecimal.valueOf(numberToAdd));
        }



            return iWantToBe > 0? true: false ;
    }



    @Override
    public List<MatchComplete> allUser(int id) {

        List<MatchComplete>goodLuck = new ArrayList<>();
        String thatAll = "SELECT m.liked_id,t.user_bio,s_user_id,t.profile_picture,t.first_name, t.last_name,p.hobbies,p.relationship_status, liked_time, t.age,t.birth_date, t.gender FROM liked_user AS m\n" +
                "JOIN users AS t ON m.s_user_id = t.user_id\n" +
                "JOIN preference as p ON t.user_id = p.user_id \n" +
                "WHERE f_user_id = ?";
        SqlRowSet thatAlot = iCanFeel.queryForRowSet(thatAll, id);
        if(!thatAlot.wasNull()){
            while(thatAlot.next()){
                MatchComplete oneTime = new MatchComplete();
                letTry(oneTime, thatAlot);
                goodLuck.add(oneTime);
            }

        }
        return goodLuck;
    }

    @Override
    public MatchComplete getUserOne(int userId,int id) {
        MatchComplete firstTime = null;
        MatchComplete secondTime = null;
        String getAllMatches ="SELECT match_id,t.user_bio,t.user_id,t.profile_picture,t.first_name, t.last_name,p.hobbies,p.relationship_status,match_date, t.age,t.birth_date, t.gender FROM match_user AS m\n" +
                "JOIN users AS t ON m.f_user_id = t.user_id\n" +
                "JOIN preference as p ON t.user_id = p.user_id \n" +
                "WHERE (s_user_id = ? AND f_user_id = ?) OR (s_user_id = ? AND f_user_id = ?)";

        String getSecondMatches = "SELECT match_id,t.user_bio,t.user_id,t.profile_picture,t.first_name, t.last_name,p.hobbies,p.relationship_status,match_date, t.age,t.birth_date, t.gender FROM match_user AS m\n" +
                "JOIN users AS t ON m.s_user_id = t.user_id\n" +
                "JOIN preference as p ON t.user_id = p.user_id \n" +
                "WHERE (s_user_id = ? AND f_user_id = ?) OR (s_user_id = ? AND f_user_id = ?)\n";

        SqlRowSet oneThingAboutMe = iCanFeel.queryForRowSet(getAllMatches,id,userId,userId,id);
        SqlRowSet secondThing = iCanFeel.queryForRowSet(getSecondMatches,userId,id,id,userId);
        if(!oneThingAboutMe.wasNull()){
            if(oneThingAboutMe.next()){
                firstTime = justExposed(oneThingAboutMe);
            }
        }
        if(!secondThing.wasNull()){
            if(secondThing.next()){
                secondTime = justExposed(secondThing);
            }
        }

        return firstTime.getLikedUserId() == userId ? secondTime:firstTime;
    }

    @Override
    public List<Message> alongToBe(int matchId) {
        List<Message> thatAlot = new ArrayList<>();
        String getAll = "SELECT t.first_name AS second_first, t.last_name AS second_last,u.first_name, u.last_name,* FROM messages as M JOIN match_user AS j ON j.match_id=m.match_id JOIN users AS u ON j.s_user_id = u.user_id JOIN users AS t ON j.f_user_id = t.user_id WHERE m.match_id = ? ORDER BY m.message_id ASC";
        SqlRowSet andTheReason = iCanFeel.queryForRowSet(getAll, matchId);
        if(!andTheReason.wasNull()){
            while(andTheReason.next()){
            Message comeOnMan = getMessage(andTheReason);
            thatAlot.add(comeOnMan);
            }
        }

        return thatAlot;
    }

    @Override
    public boolean insertMessage(Message messageNice, int id) {
        boolean butWeStill = false;
        List<LocalDate> allToCheck = new ArrayList<>();
        SqlRowSet allDateFun = iCanFeel.queryForRowSet("SELECT * FROM messages WHERE message_date = ? AND match_id = ?",messageNice.getMessageDate(), messageNice.getMatchId());
        if(!allDateFun.wasNull()){
            while(allDateFun.next()){
                LocalDate oneDate = allDateFun.getDate("message_date").toLocalDate();
                allToCheck.add(oneDate);
            }
        }
        String inTheDay = "INSERT INTO messages (match_id, message_content, message_date,message_time, message_created) VALUES(?,?,?,?,?) RETURNING message_id";
     int numberNice = iCanFeel.queryForObject(inTheDay, int.class,messageNice.getMatchId(), messageNice.getMessageContent(),allToCheck.size()==0 ? messageNice.getMessageDate():null,messageNice.getMessageTime(),messageNice.getMessageCreated());
     if(numberNice>0){
         iCanFeel.update("INSERT INTO message_read (message_id, is_message_read,to_user_id) VALUES (?,?,?)",numberNice,false,id);

         butWeStill = true;
     }
        return butWeStill;
    }

    @Override
    public Preference getPref(int id) {
        Preference oneKick = null;
        String sqlString = "SELECT * FROM preference WHERE user_id = ?";
        SqlRowSet iWantMine = iCanFeel.queryForRowSet(sqlString, id);
        if(!iWantMine.wasNull()){
            if(iWantMine.next()){
                oneKick = iNeedYouRightNow(iWantMine);
            }
        }
        return oneKick;
    }

    @Override
    public List<MatchComplete> userCompleteMatch(int id) {
        String getAllMatches ="SELECT match_id,t.user_bio,t.user_id,t.profile_picture,t.first_name, t.last_name,p.hobbies,p.relationship_status,match_date, t.age,t.birth_date, t.gender FROM match_user AS m\n" +
                "JOIN users AS t ON m.s_user_id = t.user_id\n" +
                "JOIN preference as p ON t.user_id = p.user_id \n" +
                "WHERE s_user_id = ? or f_user_id = ?";

        String getSecondMatches = "SELECT match_id,t.user_bio,t.user_id,t.profile_picture,t.first_name, t.last_name,p.hobbies,p.relationship_status,match_date, t.age,t.birth_date, t.gender FROM match_user AS m\n" +
                "JOIN users AS t ON m.f_user_id = t.user_id\n" +
                "JOIN preference as p ON t.user_id = p.user_id \n" +
                "WHERE s_user_id = ? OR f_user_id = ?";
        List<MatchComplete>allMatchUnique = new ArrayList<>();
        List<MatchComplete>firstA = new ArrayList<>();
        List<MatchComplete>secondA = new ArrayList<>();
        SqlRowSet iJustHere = iCanFeel.queryForRowSet(getAllMatches,id,id);
        SqlRowSet secondHere = iCanFeel.queryForRowSet(getSecondMatches, id,id);
        if(!iJustHere.wasNull()&&!secondHere.wasNull()){
            while(iJustHere.next()){
                MatchComplete first = justExposed(iJustHere);
                firstA.add(first);
            }
            while(secondHere.next()){
                MatchComplete second = justExposed(secondHere);
                secondA.add(second);
            }
        }
       firstA = firstA.stream().filter((e)->e.getLikedUserId()!=id).collect(Collectors.toList());
        secondA = secondA.stream().filter((e)->e.getLikedUserId()!=id).collect(Collectors.toList());
        for (int i = 0; i < (firstA.size() == 0 ? secondA.size():firstA.size()); i++) {
            if(firstA.size()!=0) {
                allMatchUnique.add(firstA.get(i));
            }
            if(secondA.size()!=0) {
                allMatchUnique.add(secondA.get(i));
            }
        }


        return allMatchUnique;
    }

    @Override
    public List<MessageRead> signAlong(int id) {
        List<MessageRead> allMessage = new ArrayList<>();
        String recordSale = "SELECT DISTINCT(m.match_id),is_message_read,to_user_id,u.user_id, u.first_name,u.last_name, u.profile_picture,MAX(m.message_content) AS message_content  FROM message_read as mr\n" +
                "JOIN messages AS m ON mr.message_id = m.message_id\n" +
                "JOIN match_user as mu ON m.match_id = mu.match_id\n" +
                "JOIN users AS u ON mu.f_user_id = u.user_id\n" +
                "WHERE to_user_id = ?\n" +
                "GROUP BY m.match_id,is_message_read,to_user_id,u.user_id, u.first_name,u.last_name, u.profile_picture";
        String becomeNUll = "SELECT DISTINCT(m.match_id),is_message_read,to_user_id,u.user_id, u.first_name,u.last_name, u.profile_picture,MAX(m.message_content) AS message_content  FROM message_read as mr\n" +
                "JOIN messages AS m ON mr.message_id = m.message_id\n" +
                "JOIN match_user as mu ON m.match_id = mu.match_id\n" +
                "JOIN users AS u ON mu.s_user_id = u.user_id\n" +
                "WHERE to_user_id = ?\n" +
                "GROUP BY m.match_id,is_message_read,to_user_id,u.user_id, u.first_name,u.last_name, u.profile_picture";
        SqlRowSet firstVersion = iCanFeel.queryForRowSet(recordSale, id);
        SqlRowSet secondVersion = iCanFeel.queryForRowSet(becomeNUll, id);
        if(!secondVersion.wasNull() && !firstVersion.wasNull()){
            while(secondVersion.next() && firstVersion.next()){
                MessageRead keepLoving = thatRight(firstVersion);
                MessageRead secondLoving = thatRight(secondVersion);
                allMessage.add(keepLoving.getUserId() == keepLoving.getToUserId() ? secondLoving:keepLoving);
            }
        }

        return allMessage;
    }

    public static Preference iNeedYouRightNow(SqlRowSet anyWho){
        Preference oneTime  = new Preference();
        oneTime.setHobbies(anyWho.getString("hobbies").split(";"));
        oneTime.setRelationshipStatus(anyWho.getString("relationship_status"));
        oneTime.setUserId(anyWho.getInt("user_id"));
        return oneTime;
    }


    public static MessageRead thatRight(SqlRowSet oneSet){
        MessageRead hiThere = new MessageRead();
        hiThere.setMatchId(oneSet.getInt("match_id"));
        hiThere.setMessageRead(oneSet.getBoolean("is_message_read"));
        hiThere.setToUserId(oneSet.getInt("to_user_id"));
        hiThere.setUserId(oneSet.getInt("user_id"));
        hiThere.setFirstName(oneSet.getString("first_name"));
        hiThere.setLastName(oneSet.getString("last_name"));
        hiThere.setProfilePicture(oneSet.getString("profile_picture"));
        hiThere.setMessageContent(oneSet.getString("message_content"));
        return hiThere ;
    }

    public static LikedUser oneLike(SqlRowSet rowMe){
        LikedUser likedUser = new LikedUser();
        likedUser.setFirstUserId(rowMe.getInt("f_user_id"));
        likedUser.setSecondUserId(rowMe.getInt("s_user_id"));
        likedUser.setLikedId(rowMe.getInt("liked_id"));
        likedUser.setLikedTime(rowMe.getTime("liked_time").toLocalTime());
        return likedUser;
    }

    public static Message getMessage(SqlRowSet oneRowSet){
        Message oneMessage = new Message();
        if(oneRowSet.getString("second_first")!=null){
            oneMessage.setSecondFirst(oneRowSet.getString("second_first"));
        }
        if(oneRowSet.getString("second_last")!=null){
            oneMessage.setSecondLast(oneRowSet.getString("second_last"));
        }
        oneMessage.setFirstName(oneRowSet.getString("first_name"));
        oneMessage.setLastName(oneRowSet.getString("last_name"));
        oneMessage.setMatchId(oneRowSet.getInt("match_id"));
        oneMessage.setMessageContent(oneRowSet.getString("message_content"));
        if(oneRowSet.getDate("message_date")!=null) {
            oneMessage.setMessageDate(oneRowSet.getDate("message_date").toLocalDate());
        }
        oneMessage.setMessageCreated(oneRowSet.getDate("message_created").toLocalDate());
        oneMessage.setMessageTime(oneRowSet.getString("message_time"));
        return oneMessage;
    }

    public static User iNeedUser(User userNow, SqlRowSet rowSet){
        userNow.setUserId(rowSet.getInt("user_id"));
        userNow.setProfilePicture(rowSet.getString("profile_picture"));
        userNow.setFirstName(rowSet.getString("first_name"));
        userNow.setLastName(rowSet.getString("last_name"));
        userNow.setPhoneNumber(rowSet.getString("phone_number"));
        userNow.setEmail(rowSet.getString("email"));
        userNow.setPassWord(rowSet.getString("password"));
        userNow.setAge(rowSet.getInt("age"));
        userNow.setGender(rowSet.getString("gender"));
        userNow.setBirthDay(rowSet.getString("birth_date"));
        userNow.setBio(rowSet.getString("user_bio"));
        return userNow;
    }

    public void letTry(MatchComplete matchUser, SqlRowSet rowSet) {

            matchUser.setLikedUserId(rowSet.getInt("s_user_id"));
            matchUser.setLikedFirstName(rowSet.getString("first_name"));
            matchUser.setLikedLastName(rowSet.getString("last_name"));
            matchUser.setProfilePicture(rowSet.getString("profile_picture"));
            matchUser.setHobbies(rowSet.getString("hobbies").split(";"));
            matchUser.setRelationshipStatus(rowSet.getString("relationship_status"));
            matchUser.setLikedTime(rowSet.getTime("liked_time").toLocalTime());
            matchUser.setAge(rowSet.getInt("age"));
            matchUser.setGender(rowSet.getString("gender"));
            matchUser.setBirthDate(rowSet.getString("birth_date"));
            matchUser.setUserBio(rowSet.getString("user_bio"));

    }
    public MatchComplete justExposed(SqlRowSet rowSet){
        MatchComplete matchUser = new MatchComplete();
        matchUser.setMatchId(rowSet.getInt("match_id"));
        matchUser.setLikedUserId(rowSet.getInt("user_id"));
        matchUser.setLikedFirstName(rowSet.getString("first_name"));
        matchUser.setLikedLastName(rowSet.getString("last_name"));
        matchUser.setProfilePicture(rowSet.getString("profile_picture"));
        matchUser.setHobbies(rowSet.getString("hobbies").split(";"));
        matchUser.setRelationshipStatus(rowSet.getString("relationship_status"));
        matchUser.setMatchDate(rowSet.getDate("match_date").toLocalDate());
        matchUser.setAge(rowSet.getInt("age"));
        matchUser.setGender(rowSet.getString("gender"));
        matchUser.setBirthDate(rowSet.getString("birth_date"));
        matchUser.setUserBio(rowSet.getString("user_bio"));
        return matchUser;
    }
}
