package com.devgabriel.controlefinanceiro

import com.devgabriel.controlefinanceiro.local.models.Despesa

class DataSource {

    companion object {

        fun createDataSet() : ArrayList<Despesa>{

            val list = ArrayList<Despesa>()

            list.add(
                Despesa(
                    1,
                    "Mesa de 1,70 para colocar meu PC",
                    "R$ 25,50",
                    "03/06/2024"
                )
            )
            list.add(
                Despesa(
                    1,
                    "Comida",
                    "R$ 15,50",
                    "02/06/2024"
                )
            )
            list.add(
                    Despesa(
                        1,
                        "Comida",
                        "R$ 81,00",
                        "01/06/2024"
                    )
                    )
            list.add(
                    Despesa(
                        1,
                        "Comida",
                        "R$ 45,50",
                        "06/06/2024"
                    )
                    )
            list.add(
                    Despesa(
                        1,
                        "Comida",
                        "R$ 45,50",
                        "06/06/2024"
                    )
                    )
            list.add(
                    Despesa(
                        1,
                        "Comida",
                        "R$ 9,50",
                        "05/06/2024"
                    )
                    )
            list.add(
                    Despesa(
                        1,
                        "Comida",
                        "R$ 5,50",
                        "05/06/2024"
                    )
                    )
            list.add(
                Despesa(
                    2,
                    "Corrida 99",
                    "R$ 15,50",
                    "06/06/2024"
                )
            )
            list.add(
                Despesa(
                    3,
                    "internet",
                    "R$ 99,90",
                    "06/06/2024"
                )
            )
            return list
        }


    }
}