<?php
namespace Zilic;

use stdClass;
use Faker\Factory;

class Luk
{
    public function getLuka()
    {
        $faker = \Faker\Factory::create();
        $luka=[];
        
        for($i=1;$i<=17;$i++){
            $l = new stdClass();
            $l->sifra=$i;
            $sloj = rand(11,15);
            $l->slojevi= $sloj;

            $int= rand(1577836890,1577836950);
            $minute = date("i:s",$int);
            
            $l->vrijeme=$minute;
            $suze = rand(25,35)/10;
            $l->mlSuza=$suze;

            $luka[]=$l;
        }
        return $luka;
    }
}