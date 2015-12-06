package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by member on 11/30/ 15.
 */
public class TapeMeasure extends OpMode {

    DcMotor tapeMeasure;

    public void init() {
        tapeMeasure = hardwareMap.dcMotor.get("tape");
    }

    public void loop() {
        if (gamepad1.a) {
            tapeMeasure.setPower(1);
        }
        else if (gamepad1.b) {
            tapeMeasure.setPower(-1);
        }
        else {
            tapeMeasure.setPower(0);
        }
    }
}