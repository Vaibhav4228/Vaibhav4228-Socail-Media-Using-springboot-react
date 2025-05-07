package com.vaibhav.controller;

import com.vaibhav.dto.CallInvite;
import com.vaibhav.dto.CallResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
public class VideoCallController {

    // Handle call invitation (Offer)
    @MessageMapping("/call/invite")
    @SendTo("/topic/call/response")
    public String handleCallInvite(CallInvite invite) {

        System.out.println("Received call invite from: " + invite.getFromUser() + " to: " + invite.getToUser());
        

        return "Call Invitation from: " + invite.getFromUser() + " is calling you!";
    }


    @MessageMapping("/call/response")
    public void handleCallResponse(CallResponse response) {

        if (response.isAccepted()) {
            System.out.println("Call accepted by: " + response.getToUser());
        } else {
            System.out.println("Call rejected by: " + response.getToUser());
        }

    }
}
