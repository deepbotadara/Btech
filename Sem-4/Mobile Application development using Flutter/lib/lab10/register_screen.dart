import 'package:flutter/material.dart';

class RegisterScreen extends StatefulWidget {
  const RegisterScreen({super.key});

  @override
  State<RegisterScreen> createState() => _RegisterScreenState();
}

class _RegisterScreenState extends State<RegisterScreen> {

  TextEditingController _nameController = TextEditingController();
  TextEditingController _mobileController = TextEditingController();
  TextEditingController _emailPasswordController = TextEditingController();
  TextEditingController _passwordController = TextEditingController();
  TextEditingController _confirmPasswordController = TextEditingController();
  bool isObsecure = true;
  final GlobalKey<FormState> _formKey = GlobalKey<FormState>();
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Register Screen')),
      body: Stack(fit: StackFit.expand, children: [
        //Image.network('data:image/jpeg;base64,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',fit: BoxFit.contain,),
        Form(
          key: _formKey,
          child: Column(
            mainAxisSize: MainAxisSize.max,
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              Container(
                  width: 150,
                  height: 150,
                  decoration: BoxDecoration(
                      //image: DecorationImage(fit: BoxFit.cover,image: NetworkImage('GDlN+C1k+SIORyKYadVv5SYsVslumrkcbi5Vp7UvZjpFckeU5PJvnv1W+HsvMOGuKuoYUjmSJJGssJJGsy1TSNWHqRrthJIxthrYmhbtLhquRYcfkdXht5pseTfdLWuduk+i40aLjRpmwmKnSmpwdmvJrk+hviyWx26qo8uGuSvTZ2eW5hCvDajuku/HWL+RfYc1ctdw8/nwWw21LbJkAAAAAAAAAAAAAAABr43FxowcpvwWsnyRByORTDTqt/KTFitkt01cjjcXKtPal7MdIrkjynJ5N89+q3w9l5hw1xV1DCkcyRJI1mWE0jWZavTMUmY2JJEUtZSSMMJpGssPUjXbDSxmFt2o8NVy6+Ba8XlRfwX8/1dOLLvwy07nfp0aLmdGi40zpmwmLnSmpwdmvJrk+hvjvbHbqqiy4a5a9Nna5ZmEMRDajuku/DWL+RdYc0ZK7h53Px7YbdNvi3CZAAAAAAAAAAAAABr43FxowcpvwWsnyRByORTBTqt/KTFitkt01cjjcXKtPal7MdIrkjynJ5N89+q3w9l5hw1xV1DCkc0pEkjXbCaRrMtRuxJjx9XfLMRtC50ab6ThPmQ5cW++Glqs6RxSiTSNWr1I1mRJIxtqrcfg9m8oLs+suXVdC54fMi/gv5+/u7MGbfhs0Lllp1aLjRouNGmfB4udGanB2a8muT6EmO9qTuEWbDXLXps7fK8xhiIbUd0l34axfyLfFljJG4ec5HHtht02+LdJUAAAAAAAAAAAa+NxcaMHKb8FrJ8kQcjkUwU6rfykxYrZLdNXI43FzrT2pezHSK5I8pyeTfPfqt8PZeYcNcVdQwpHNMpEkjWZYTSNZlq8nO3iS4sXV3z5M1rtiudekui40aLjRpmo1rbnw58jlz4N+KvmivTffDbRXy50kjVhJI1mWErGu2FTmOA2bzguz60fu9V0L3gc6Mn9PJ5+k+/7u7j8jfhsrbltp2aLjRouNGmfB4ydGanB2kvJrk1qjelppO4RZsFctemzusqzKGIhtR3SXfhrF/ItceSLxuHmuRx7YLdNvj7t0kQAAAAAAAAGLFV1ThKbu1FXsuLIs2WMVJvPo3x0m9orHq47G4uVae1L2Y6RXJHkuTyb579Vvh7L3DhrirqGFI5pSJJGrCaRrMtUKlS27X3E+HDNu+fJtWu2DaO3pTaNoaNG0NBtDRpf5HlF7Vaq3cYQf8pFrw+F/nf8AKFVzOX/hT85WGY4C95wXa9aPPqupydq9lfKbzYY7/WPf93Lgz9Pht5KlI8nLuSRrLCSRqwkkY21c9m9CFOfYa7W9w+6ep7NzZM2Lxx5evuteLktevi+LRuWOnXouNGi40aZ8FjJ0ZqdN2kvJrk1yN6Wmk7hDmwVy06bPoGWYxV6UaiTjtcYvRrj4oscWSMleqHl8+GcV5pPo2iRCAAAAAAA0c7+zVPBfyRx9ofVr/wD3q6OL9NVyKR5CV4kkazLCSRrtqhWq7O5cfcdGDB1+K3k3pTbW2iw06NPLmdGi40aLjRp0WRZNe1Wqt3GEH/KRZcTif53/AChUczmf9eP85dGWiqAK7MMDe84Lf60efVdTzva3ZPym82GO/wBY9/3dWHNrw2ViR5GXYkkatWhmmYqktmNnUflFc2WfZ/Z88ieu/wDb+rq4/GnJO58nOym2222297b4tnqa0isajyW0ViI1Dy5nTOi40aLjRpt4XD37UuGi59WV3K5WvBT4oMuT0h230d+zr80/eWvZX1ePxn9XnOb9NP5LMsXIAAAAAAA0s6+z1PBfyRxdo/Vr/h/tPxfpauSSPH7XiSRrMtWOvW2dy73uOrj8fr8VvL9UlKdXfLT2iy6XTouZ0aLjRouNGnR5Bkt7Vay3cacH/KS+BYcXi/53+Cn5vN/68f5y6UslSAAAGhjsFe8oLf6y59V1PN9r9kfKbzYY8XrHv+/6unDm14Zc5muZKitmO+q1/qK5spezuzbZ56791Y/8rXjcacs7ny/Vzcptttttve2+LZ6ytIrGo8lxFYiNQ8uZ0yXGguNDdweFv2pcNFz6sq+ZzNeCnn6y5suX/GrdZVOZ1X0d+zr80/eep7K+rR+MqXm/TT+SzLFyAAAAAAANLOfs9TwX8kcXaP1a/wCH+0/G+lq5VI8bMrphxGI2dy73uOvjcacnit5fqlx4+rvnyaLkWvS6tPLjRouNGi40aWmXYHhOa6xj8WU3O52v6eOfxlw58+/DV1OX43a7M+9o/vf2XHZPa3y2sOafF6T7/ups2Hp8UeTfPQOYAAAKL6R58sOvR07OvJeKpp+tLryRHe/SseDwZzz1W/t/VwdSo5Nyk25Sbbbd229Wcunp61isajyeXGmdFxoLjQ38Dg72nNbvVXPqyp5vN1/Tx+frLkzZv8arBlO5UWbMuq+jv2dfmn7z1PZX1aPxlS836afyWZYuQAAAAAABp5x9nqeC/kjh7S+q3/D/AGn430tXG4rE7O5d73HmuLxflPFby/Vf48XV3z5K9yLiI15OzTy40aLjRouNGlvlmX8J1F1jF+9lJ2hz/PFjn8ZV/I5H+NVoykcTw2idTuGy1y/HbVoT72j+9/Z7DsntX5bWLLPi9J9/3cObD0+KPJYF+5gCh+kmfrDL0dO0q8l4qmvvS68l/wCelraWPA4E556rf2/q4KpUcm5SbcpNuTbu23qyB6itIrHTEdyNzGm2i40wXGhY5fgr2nNbvVjz6voU/P53T/Tx+frLjz59eGqzZSOOEWbNkWbMuq+jv2dfmn7z1PZX1aPxlS836afyWZYuQAAAAAABgx1D0tKcE9lyVlK17PR2Is2KMtJpbylJiv0Xi3s+d43DTo1JQqK01/tSX3k9UV1sfR4Xq8OWmWkWp5MFzGkpcaC40abeWSpqqvScPVv3VL/scXaFc04Z+S/P319zn5MX6PA6VnkVOizLMPDZsibROu+BbZdj9q0J97R/e/s9f2V2r8tEYss+L0n3/dw58HT4q+TS+kv0gWGj6OnaVeS8VTT9aXXki8tbTp4HAnkT1W/t/VwFSo5Nyk3KUm3KTd229WyF6itYrGojuRuGxcBcaFnluAvac1u4xi9er6FL2h2h07x457/WXFyORrw1WrKJwosyzCLNmz2lSlOSjFNyk7JIlx0te0VrG5li1orG5dflmF9DSjBu73t24XeiPXcPB8hiikyos+X5S82bZ0oQAAAAAAADQzjK4YmGzLdOPcnrF/FEeTHF41Lp43JvgvuPL1hwGNws6NR06itKPk1o09UcNqTWdS9Rhy0zU6qsFzXSXRcaNFxo0tsqzPZtTqPs8IyenR9Ck7R7N6t5cUd/rHur+Txd+OnwXbPOq6HhtDZFmRFm8Trvhs53O8vlGUqsW5Rk253bclJ631R6vsztL5aPk8s+L39/3WnD5ETEY57vZUl1pYA0A0LXLMuvadRbuMYvXq+hR9o9o9O8WKe/1lw8jk68FVuygcCLMwyizZmHtOnKclGKvKW5JEuPHbJaK1jcyWtFY3Lqcry2NGN3Z1Jd6XLouh6vhcKvHr72nzlS8jkTln7m+dznAAAAAAAAAACvzjKoYmnsy3Tj/wAc7b4v4o0vSLQ6eLyr4L9UeXrHu+fY3CzoVHTqK0o+TWjT1Rx2rMTqXqcOamanXRguY0lLjQXGjS3ynNNm1Oo+zwjJ6dH0KLtLszq3lxR3+se7g5PF346fBeHnVcizMCLNmyMkbVnXfDMOdzbLfR3nBf8Az1X3P6PV9m9pfKx8nknxe/v+6143J6vDbz/VVly7lrleW3tUqLdxjF69X0KPtLtLp3ixT3+suDk8nXgp8VyzzyvRZs2RZmGSnTc5KMVeUtySJceO2S0VrG5li1orG58nUZXlyoxu99SXely6Loes4XCrx6+9p85U/I5E5Z+5vne5wAAAAAAAAAAAAK/OcphiqezLdON/Rztvi/iuhrasWh08XlX49+qvl6x7vneNwk6FSVOorSj5NaNPVHLNZiXq8OamanXSWC5jSUuNBcaFxlGabNqdR9nhCT9Xo+hRdpdmdW8uKO/1j3cHK4u/HT4Lxnm1YizZsizaGUZI2idTuGVZHKIKpt+pxUNFL5FvbtfLbD8n6+/3f+3ZPLvNOn192+yrcqLNmUWbNinTc5KMVeUtyRJix2yWitY3MsWtFY3Lp8sy9UY799SXely6Loeu4PBrxq+9p85VGfPOWfubx3ucAAAAAAAAAAAAAAArs6ymGKp7Mt0439HUtvi/iuaNbViXVxeVfj36q+XrHu+dY7CToVJU6itKPk1pJPVEE109ZhzUzUi9PJguY0lLjQXGhb5RmmzanUfZ4Qk/V6PoUPafZfVvLijv9Y91fyuLvx0+C9Z5tWos2hlFmzKLMsos2ZRZtDJTpuTUYq8nuSJceO2S0VrG5ktaKxuXS5bl6oxu99R96XLouh6/g8GvGr72nzlUZ885Z+5vHegAAAAAAAAAAAAAAAAACuzvKIYqnsy3Tjd06lt8X8VzRiY26uLyr8e/VXy9Y93zjHYSdCpKnUWzKPk1pKL1RDNdPW4M1M1IvSe5r3MaSlxoLjQuMozTZtTqPs8ISfq9H0KHtPsvq3lxR3+se6v5XF346fBes83CtRZsyizLKLNmSFNykoxV5PgiXFjtktFaRuZLWisbl0mW4BUY34zfely6Loew4HBrxq787T5yqc+eck/c3SwQAAAAAAAAAAAAAAAAAAAAVud5RTxdPZl2Zxu6dRLfF/Fc0YmNuricu/Hv1V8vWPd83x2DnQqSp1FacfJrSUXqiOY09bgz0zUi9J7mAwmAAFvlGabNqdR9nhCT9Xo+hQ9p9mde8uKO/wBY91fyuLvx0+C9Z5tWosyyQg5NRirt7kiXFjtktFKRuZLWisbl0WXYBUlzm+9Ll0XQ9lwOBXjV97T5yqs2eck/c3SwQAAAAAAAAAAAAAAAAAAAAAAFbneUQxdPZl2Zxu6dS2+L+K5oxMbdXE5d+Pfqr5ese75vjsHOhUlTqLZlHya0lF6ojmNPW4M9M1IvSe5gMJgAZFvlOZ7NqdR9nhCT9Xo+hQ9p9mde8uKO/wBY91fyeLvx0+C9hByajFXb4I8/ixWyXilY3Mq21orG5dDl+BVJc5vvS+C6HsuBwK8Wvf32nzn/AFCqzZpyT9zcLFCAAAAAAAAAAAAAAAAAAAAAAAAGjmmU0cSoqrG+y7xknaS5q/IxMbdHH5OTBO6SrvqhhOVT9Rjph1f8tyfePhB9UMJyqfqMdMH/AC3J94+EH1QwnKp+ox0wf8tyfePhB9UMJyqfqMdMH/Lcn3j4Qs8vy2nQjaG09E5PaklyvyIMfFxY7zkrXUy482e+Wd2bh0IQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAD/9k='))
                      image: DecorationImage(
                          image: NetworkImage(
                              'data:image/jpeg;base64,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')))),
              SizedBox(
                height: 25,
              ),
              Padding(
                padding: const EdgeInsets.symmetric(horizontal: 175),
                child: TextFormField(
                  validator: (value) {
                    if (value!.isEmpty || value == null) {
                      return "Username Must be NonEmpty";
                    }
                    if (value.length < 5) {
                      return "Username Must be at least 5 character long";
                    }
                  },
                  controller: _nameController,
                  decoration: InputDecoration(
                      labelText: "Username",
                      prefixIcon: Icon(Icons.person),
                      hintText: "Enter Username here",
                      border: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(16))),
                ),
              ),
              SizedBox(
                height: 25,
              ),
              Padding(
                padding: const EdgeInsets.symmetric(horizontal: 175),
                child: TextFormField(
                  validator: (value) {
                    if (value!.isEmpty || value == null) {
                      return "Username Must be NonEmpty";
                    }
                    if (value.length < 5) {
                      return "Username Must be at least 5 character long";
                    }
                  },
                  controller: _nameController,
                  decoration: InputDecoration(
                      labelText: "Username",
                      prefixIcon: Icon(Icons.person),
                      hintText: "Enter Username here",
                      border: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(16))),
                ),
              ),
              SizedBox(
                height: 25,
              ),
              Padding(
                padding: const EdgeInsets.symmetric(horizontal: 175),
                child: TextFormField(
                  validator: (value) {
                    if (value!.isEmpty || value == null) {
                      return "Username Must be NonEmpty";
                    }
                    if (value.length < 5) {
                      return "Username Must be at least 5 character long";
                    }
                  },
                  controller: _nameController,
                  decoration: InputDecoration(
                      labelText: "Username",
                      prefixIcon: Icon(Icons.person),
                      hintText: "Enter Username here",
                      border: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(16))),
                ),
              ),
              SizedBox(
                height: 25,
              ),
              Padding(
                padding: const EdgeInsets.symmetric(horizontal: 175),
                child: TextFormField(
                  validator: (value) {
                    if (value!.isEmpty || value == null) {
                      return "Username Must be NonEmpty";
                    }
                    if (value.length < 5) {
                      return "Username Must be at least 5 character long";
                    }
                  },
                  controller: _nameController,
                  decoration: InputDecoration(
                      labelText: "Username",
                      prefixIcon: Icon(Icons.person),
                      hintText: "Enter Username here",
                      border: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(16))),
                ),
              ),
              SizedBox(
                height: 25,
              ),
              Padding(
                padding: const EdgeInsets.symmetric(horizontal: 175),
                child: TextFormField(
                  controller: _passwordController,
                  validator: (value) {
                    if (value!.isEmpty || value == null) {
                      return "Password Must be NonEmpty";
                    }
                    if (value.length < 8) {
                      return "Password Must be at least 8 character long";
                    }
                  },
                  obscureText: isObsecure,
                  decoration: InputDecoration(
                      labelText: "Password",
                      prefixIcon: Icon(Icons.password),
                      hintText: "Enter Password here",
                      border: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(16)),
                      suffixIcon: IconButton(
                          onPressed: () {
                            setState(() {
                              isObsecure = !isObsecure;
                            });
                          },
                          icon: Icon(isObsecure
                              ? Icons.visibility
                              : Icons.visibility_off))),
                ),
              ),
              SizedBox(
                height: 25,
              ),
              Padding(
                padding: const EdgeInsets.only(top: 20),
                child: ElevatedButton(
                    style: ButtonStyle(
                        backgroundColor:
                            WidgetStatePropertyAll<Color>(Colors.green)),
                    onPressed: () {
                      if (_formKey.currentState!.validate()) {
                        print('Login Success');
                      }
                    },
                    child: const Text(
                      "Register",
                      style: TextStyle(color: Colors.white),
                    )),
              ),
              Padding(
                  padding: const EdgeInsets.only(top: 20),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Text(
                        "Are you Registered User?",
                      ),
                      InkWell(
                          child: Text(
                        'Login',
                        style: TextStyle(color: Colors.blueAccent),
                      ))
                    ],
                  )),
            ],
          ),
        ),
      ]),
    );
  }
}