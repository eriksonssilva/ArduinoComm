#define myLed 2

void setup() {

  pinMode(myLed, OUTPUT);

  Serial.begin(9600);

  while (!Serial);  

}

void loop() {

  if (Serial.available()) {

    char ledState = Serial.read();

    if (ledState == '1') {

      digitalWrite(myLed, HIGH);

    }

    else if (ledState == '2') {

      digitalWrite(myLed, LOW);

    }

    else {

    }
  }
}