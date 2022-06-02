package com.example.bankanagemen.excption;

public class InvalidIdException extends RuntimeException{

        public InvalidIdException(String massage){

            super(massage);
        }

}
