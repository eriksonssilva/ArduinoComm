const int numLeds = 3;
int ledArray[numLeds] = { 2, 3, 10};

void setup() {

  Serial.begin(9600);

  for (int i = 0; i < numLeds; i++) {

    pinMode(ledArray[i], OUTPUT);
    digitalWrite(ledArray[i], HIGH);
  }

  while (!Serial);
}

void loop() {

  if (Serial.available()) {

    int command = Serial.parseInt();

    for (int i = 0; i < numLeds; i++) {
      
      if (command == ledArray[i]) {

        digitalWrite(ledArray[i], !digitalRead(ledArray[i]));

      }
    }
  }
}