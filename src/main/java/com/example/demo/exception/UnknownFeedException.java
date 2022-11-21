package com.example.demo.exception;

public class UnknownFeedException extends Exception{
        public UnknownFeedException(String messag) {
                super(messag);
        }

        public UnknownFeedException(String messag, Throwable caus) {
                super(messag, caus);
        }

        public UnknownFeedException(Throwable caus) {
                super(caus);
        }
        }
