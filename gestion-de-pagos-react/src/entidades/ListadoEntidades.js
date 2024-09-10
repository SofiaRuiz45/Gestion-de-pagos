
// video: https://www.udemy.com/course/draft/5371228/learn/lecture/38260426#content
// quede en el video: https://www.udemy.com/course/draft/5371228/learn/lecture/38260456#content (de manera dinamica se ponen los datos uardados en la DB)
import axios from 'axios';
import React, { useEffect, useState } from 'react'

export default function ListadoEntidades() {

    const urlBase= 'http://localhost:8082/gestion-de-pagos/entidad'

    const [entidades, setEntidades] = useState([]);

    useEffect(()=> {
        cargarEntidades();
    },[]);

    const cargarEntidades = async()=> {
        const resultado = await axios.get(urlBase);
        console.log("resultado cargar entidades");
        console.log(resultado.data);
        setEntidades(resultado.data);
    }

  return (
    <div className='container text-cemter' style={{margin: "30px"}}>
        <h3>Sistema de gestion de pagos</h3>
    </div>
  )
}
