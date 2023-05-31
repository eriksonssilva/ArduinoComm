const int numLeds = 3;
int ledArray[numLeds] = { 2, 3, 4 };

void setup() {

  Serial.begin(9600);
  Serial.setTimeout(50);

  for (int i = 0; i < numLeds; i++) {

    pinMode(ledArray[i], OUTPUT);
    digitalWrite(ledArray[i], HIGH);

  }

  while (!Serial);
}

void loop() {

  if (Serial.available()) {

    String readString = Serial.readString();

    if (readString.indexOf("S") == 0) {

      setLedState(readString);

    } else if (readString.indexOf("G") == 0) {

      getLedState(readString);

    }
  }
}

void setLedState(String readString) {

  int command = readString.substring(1).toInt();

  for (int i = 0; i < numLeds; i++) {

    if (command == ledArray[i]) {

      digitalWrite(ledArray[i], !digitalRead(ledArray[i]));

    }
  }
}


void getLedState(String readString) {

  int command = readString.substring(1).toInt();

  for (int i = 0; i < numLeds; i++) {

    if (command == ledArray[i]) {

      Serial.print(digitalRead(ledArray[i]));

    }
  }
}