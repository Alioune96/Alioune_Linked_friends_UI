package com.techelevator.tenmo.Tenmo.dao;

import com.techelevator.tenmo.Tenmo.model.Transfers;

import java.util.List;
import java.util.Map;

public interface TransferDao {
    //question 1 was complete



    //question 2 was complete

    //question 3 complete

    //question 4/
    // need two updates,
    Map<Integer,String> listOf(int userId);

    //question 5 // done
    List<Transfers> getTransfersByUserId(int id);

    //question 6 // done
    Transfers getTransfersById(int id);

    String sendToUser(Transfers newTransfer);


    //question 8 //  done
    List<Transfers> getPendingTransfers(int id);

    //request payment
    String confirmation(Transfers transferRequest);

    String approved(int transferId);

    String rejected(int transferId);








}

