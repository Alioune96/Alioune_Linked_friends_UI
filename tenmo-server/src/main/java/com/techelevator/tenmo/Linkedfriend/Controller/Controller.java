package com.techelevator.tenmo.Linkedfriend.Controller;

import com.techelevator.tenmo.Linkedfriend.Model.*;
import com.techelevator.tenmo.Linkedfriend.Res;
import com.techelevator.tenmo.Linkedfriend.Service;
import com.techelevator.tenmo.Linkedfriend.dataaccessobject.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.crypto.dsig.spec.XPathFilter2ParameterSpec;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;


@RestController
@CrossOrigin
public class Controller {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private Service comeOut;



    @RequestMapping(path = "/linkUserCreated", method= RequestMethod.POST)
    public User allMe(@RequestBody User user){
        return userDAO.getMeMyMoney(user);
    }

    @RequestMapping(path = "/insertConfirm", method = RequestMethod.POST)
    public boolean iNeedACov(@RequestBody Confirmation confirmation){
        return userDAO.gotGetGyat(confirmation);
    }

    @RequestMapping(path = "/lastConfirm", method = RequestMethod.POST)
    public boolean lastTime(@RequestBody Confirmation body){
        return userDAO.goodToGo(body);
    }

    @RequestMapping(path = "/exactlyCopy", method = RequestMethod.POST)
    public Object iDidYou(@RequestParam("image")MultipartFile file) throws IOException, GeneralSecurityException {
        if(file.isEmpty()){
            return "Not entered in good drive";
        }
        File tempMan = File.createTempFile("temp", null);
        file.transferTo(tempMan);
        Res res = comeOut.uploadImageToDrive(tempMan);

        return res;
    }

    @RequestMapping(path = "/userPreference", method = RequestMethod.POST)
    public boolean notRightNow(@RequestBody Preference onePreference){
        return userDAO.makePreference(onePreference);
    }

    @RequestMapping(path = "/linkedFriendAlg/{id}", method = RequestMethod.GET)
    public List<CombineUserCombine> allForPage(@PathVariable int id) throws Exception {
        try {
            return userDAO.basedOnYourUser(id);
        }catch (Exception e){
          throw new Exception(e.getMessage());
        }
    }

    @RequestMapping(path = "/logUser", method = RequestMethod.POST)
    public CombineUserCombine userStuff(@RequestBody UserLog oneThing ){
        return userDAO.needUser(oneThing);
    }

    @RequestMapping(path = "/userLiked", method = RequestMethod.POST)
    public boolean thatLikeUser(@RequestBody LikedUser user){
        return userDAO.thatMean(user);
    }

    @RequestMapping(path = "/userLoveConnection/{id}", method = RequestMethod.GET)
    public List<MatchComplete> thatADebate(@PathVariable int id){
        return userDAO.allUser(id);
    }

    @RequestMapping(path = "/userDetail/{userId}/{id}", method = RequestMethod.GET)
    public MatchComplete thatOne(@PathVariable int userId, @PathVariable int id){
        return userDAO.getUserOne(userId,id);
    }

    @RequestMapping(path = "/getMessage/{id}", method = RequestMethod.GET)
    public List<Message> thatMean(@PathVariable int id){
        return userDAO.alongToBe(id);
    }

    @RequestMapping(path = "/insertMessage/{id}", method = RequestMethod.POST)
    public boolean outLaws(@RequestBody Message oneMessage, @PathVariable int id){
        return userDAO.insertMessage(oneMessage, id);
    }

    @RequestMapping(path = "/userPreferenceGetter/{id}", method = RequestMethod.GET)
    public Preference getPreference(@PathVariable int id){
        return userDAO.getPref(id);
    }

    @RequestMapping(path = "/userRealMatch/{id}",method = RequestMethod.GET)
    public List<MatchComplete> thisTimeAround(@PathVariable int id){
        return userDAO.userCompleteMatch(id);
    }

    @RequestMapping(path = "/messageRead/{id}", method = RequestMethod.GET)
    public List<MessageRead> getMessage(@PathVariable int id){
        return userDAO.signAlong(id);
    }



}
