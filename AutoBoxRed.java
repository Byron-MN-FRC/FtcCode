package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous

public class AutoParkRed extends LinearOpMode{
    private DcMotor left;
    private DcMotor right;
    private DcMotor left2;
    private DcMotor right2;
    private DcMotor duckyeet; 
    private DcMotor lift;
    private Servo swip;
    public void moveFor(int posL, int posR,double dirL, double dirR){
      left.setTargetPosition(posL);
      right.setTargetPosition(posR);
      left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
      right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    // telemetry.addData("done?:","no");
      while(opModeIsActive() && right.isBusy()&& left.isBusy()){
        right.setPower(.5 * dirR);
        right2.setPower(.5 * dirR);
        left.setPower(.5 * dirL);
        left2.setPower(.5 * dirL);
        telemetry.addData("left",left.getCurrentPosition());
        telemetry.addData("right", right.getCurrentPosition());
        telemetry.update();
      }
      right.setPower(0);
      right2.setPower(0);
      left.setPower(0);
      left2.setPower(0);
      sleep(250);
      // telemetry.addData("done?:","yes");
    }
    public void stopMotor(){
      right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
      left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
      sleep(600);
    }
  @Override
  public void runOpMode() {
    // Put initialization blocks here.
    left = hardwareMap.dcMotor.get("left");
    right = hardwareMap.dcMotor.get("right");
    right2 = hardwareMap.dcMotor.get("right2");
    left2 = hardwareMap.dcMotor.get("left2");
    duckyeet = hardwareMap.dcMotor.get("duckyeet");
    lift = hardwareMap.dcMotor.get("lift");
    swip = hardwareMap.servo.get("swip");
    right.setDirection(DcMotorSimple.Direction.REVERSE);
    right2.setDirection(DcMotorSimple.Direction.REVERSE);
    // todo: write your code here
     waitForStart();
    if (opModeIsActive()) {
      swip.setPosition(1);
      stopMotor();
      moveFor(-500,-500,-1,-1);
      stopMotor();
      moveFor(400,-400,1,-1);
      stopMotor();
      lift.setPower(1);
      sleep(1000);
      lift.setPower(0);
      moveFor(-195,-195,-.5,-.5);
      stopMotor();
      swip.setPosition(.5);
      sleep(1000);
      swip.setPosition(1);
      sleep(750);
      moveFor(185,185,.5,.5);
      lift.setPower(-1);
      sleep(750);
      lift.setPower(0);
      moveFor(-1000,1000,-1,1);
      stopMotor();
      moveFor(-400,-400,-.5,-.5);
      stopMotor();
      moveFor(-200,200,-.5,.2);
      stopMotor();
      // moveFor(-225,-50,-.5,-.5);
      duckyeet.setPower(.5);
      sleep(3000);
      duckyeet.setPower(0);
  }
  }
}
