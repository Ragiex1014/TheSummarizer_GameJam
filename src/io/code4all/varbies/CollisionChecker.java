package io.code4all.varbies;

public class CollisionChecker {
    private Player player;

    public CollisionChecker(Player player){
        this.player = player;

    }

    public void CheckUpandDown(Obstacle obstacle){
        int value = 1;
        if(obstacle instanceof Box2){
            value = 2;
        }
        if(obstacle instanceof Box3){
            value = 3;
        }
        if(player.getPosY() - value  == obstacle.getyPos() && player.getPosX()  == obstacle.getxPos() ){

            player.setBound(true);
        }
        else{

            player.setBound(false);
        }

        if(player.getPosY() + 1 == obstacle.getyPos() && player.getPosX() == obstacle.getxPos()){
            player.setBoundDown(true);
        }
        else{
            player.setBoundDown(false);
        }

    }
    public void checkCollision(Obstacle obstacle){
        if(obstacle instanceof Box2){
            if (player.getPosX() == obstacle.getxPos() && (player.getPosY() == obstacle.getyPos() || player.getPosY() == obstacle.getyPos()+1)) {
               if (!player.isInvincible()) {
                   player.setPosX(player.getPosX() - 1);
                   player.hit();
               }
                obstacle.hide();
                return;
        }}
        if(obstacle instanceof Box3 ){
            if (player.getPosX() == obstacle.getxPos() && (player.getPosY() == obstacle.getyPos() || player.getPosY() == obstacle.getyPos() +1 ||  player.getPosY() == obstacle.getyPos() + 2)) {
                if (!player.isInvincible()) {
                    player.setPosX(player.getPosX() - 1);
                    player.hit();
                }
                obstacle.hide();
                return;
            }}
        if (obstacle instanceof Beer) {
            if (player.getPosX() == obstacle.getxPos() && player.getPosY() == obstacle.getyPos()) {
              if (player.getPosX() < 10) {
                  player.setPosX(player.getPosX() + 1);
                  player.drink();
              }
            obstacle.hide();
        } }
        if (player.getPosX() == obstacle.getxPos() && player.getPosY() == obstacle.getyPos()) {
            if (!player.isInvincible()) {
                player.setPosX(player.getPosX() - 1);
                player.hit();
            }
            obstacle.hide();
            return;
        }
    }


    public void mcCheckCollision(Obstacle obstacle){
        if(obstacle instanceof Box2){
            if (player.getMcPosX() == obstacle.getxPos() && (player.getMcPosY() == obstacle.getyPos() || player.getMcPosY() == obstacle.getyPos()+1)) {
                obstacle.hide();
                return;
            }}
        if(obstacle instanceof Box3 ){
            if (player.getMcPosX() == obstacle.getxPos() && (player.getMcPosY() == obstacle.getyPos() || player.getMcPosY() == obstacle.getyPos() +1 ||  player.getMcPosY() == obstacle.getyPos() + 2)) {
                obstacle.hide();
                return;
            }}
        if (player.getMcPosX() == obstacle.getxPos() && player.getMcPosY() == obstacle.getyPos()) {
            obstacle.hide();
        }
    }
}
