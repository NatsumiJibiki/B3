package gamesuper08;

public class Princess extends CharacterWithPlayer{

public Princess(int cx, int cy) {
x=cx;
y=cy;
}

private boolean rescueFlag = false;

public void rescued(){
if( overlapWith(myPlayer)){
rescueFlag=true;
}}


public boolean isRescue() {
return rescueFlag;
}}



