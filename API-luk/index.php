<?php
require 'vendor/autoload.php';

use Zilic\Luk;

Flight::route('GET /mi/SE',function(){

    $luk = new Luk();

    Flight::json($luk->getLuka());

});

Flight::map('notFound',function(){
    print_r($_SERVER);
   
});



Flight::start();