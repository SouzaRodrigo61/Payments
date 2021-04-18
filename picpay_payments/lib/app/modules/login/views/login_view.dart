import 'package:flutter/material.dart';

import 'package:get/get.dart';

import '../controllers/login_controller.dart';

class LoginView extends GetView<LoginController> {

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Row(
        children: [
          Container(
            width: MediaQuery.of(context).size.width * 0.3,
            decoration: BoxDecoration(
                image: DecorationImage(
                    image: AssetImage('asset/images/sideImg.png'),
                    fit: BoxFit.cover
                )
            ),
          ),
          Container(
            width: MediaQuery.of(context).size.width * 0.7,
            padding: EdgeInsets.symmetric(vertical: 60, horizontal: 20),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Header(),
                Body(),
                Footer()
              ],
            ),
          )
        ],
      ),
    );
  }
}



class Footer extends StatelessWidget {
  const Footer({
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        InkWell(
          onTap: () {
            print("Sign In");
          },
          customBorder: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(10),
          ),
          child: Container(
            padding: EdgeInsets.all(20),
            decoration: BoxDecoration(
                color: Color(0xFFFFAC30),
                borderRadius: BorderRadius.all(
                    Radius.circular(10)
                )
            ),
            child: Center(
              child: Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Text(
                    "Sign in",
                    style: TextStyle(
                        color: Color(0xFF212330),
                        fontSize: 16 * MediaQuery.of(context).textScaleFactor,
                        fontWeight: FontWeight.w700
                    ),
                  ),
                  Icon(
                    Icons.arrow_forward,
                    size: 17,
                    color: Color(0xFF212330),
                  )
                ],
              ),
            ),
          ),
        ),
        Padding(
          padding: const EdgeInsets.symmetric(
              vertical: 20
          ),
          child: InkWell(
            onTap: () {
              print("Create an account");
            },
            customBorder: RoundedRectangleBorder(
              borderRadius: BorderRadius.circular(10),
            ),
            child: Padding(
              padding: const EdgeInsets.all(8.0),
              child: Center(
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Text(
                      "Create an account",
                      style: TextStyle(
                        fontSize: 16 * MediaQuery.of(context).textScaleFactor,
                      ),
                    ),
                  ],
                ),
              ),
            ),
          ),
        ),
      ],
    );
  }
}

class Body extends StatelessWidget {
  const Body({
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Expanded(
      child: Container(
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Container(
              height: 70,
              width: 70,
              decoration: BoxDecoration(
                image: DecorationImage(
                    image: AssetImage('asset/images/logo.png'),
                    fit: BoxFit.contain
                ),
              ),
            ),
            Text(
              "eWallet",
              style: TextStyle(
                  fontSize: 40 * MediaQuery.of(context).textScaleFactor,
                  fontFamily: 'ubuntu',
                  fontWeight: FontWeight.w600
              ),
            ),
            SizedBox(
              height: 10,
            ),
            Text(
              "Open An Account For Digital \nE-Wallet Solutions.Instant \nPayouts. \n\nJoin For Free",
              style: TextStyle(
                  fontSize: 15 * MediaQuery.of(context).textScaleFactor,
                  color: Colors.grey
              ),
            )
          ],
        ),
      ),
    );
  }
}

class Header extends StatelessWidget {
  const Header({
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: [
            Text(
              "06:22 AM",
              style: TextStyle(
                  fontSize: 25 * MediaQuery.of(context).textScaleFactor,
                  fontFamily: 'avenir',
                  fontWeight: FontWeight.w500
              ),
            ),
            Expanded(
              child: Container(),
            ),
            Container(
              height: 20,
              width: 20,
              decoration: BoxDecoration(
                  image: DecorationImage(
                      image: AssetImage('asset/images/cloud.png'),
                      fit: BoxFit.contain
                  )
              ),
            ),
            SizedBox(
                width: 5
            ),
            Text(
              "34º C",
              style: TextStyle(
                  fontSize: 18 * MediaQuery.of(context).textScaleFactor,
                  fontFamily: 'avenir',
                  fontWeight: FontWeight.w800
              ),
            )
          ],
        ),
        Text(
          "Abr. 17, 2021 | Wednesday",
          style: TextStyle(
              fontSize: 16 * MediaQuery.of(context).textScaleFactor,
              color: Colors.grey
          ),
        ),
      ],
    );
  }
}