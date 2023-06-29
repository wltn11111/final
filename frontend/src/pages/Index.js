
import Header from "../components/header/Header";
import Footer from "../components/footer/Footer";
import Category from "../components/body/category/Category";
import PostButton from "../components/postButton/PostButton";
import Banner from "../components/body/banner/Banner";
import { useState, useEffect } from "react";

export default function () {

  const [fade,setFade] = useState('')

  useEffect(()=>{
    setTimeout(()=>{
      setFade('end')
    },100)
    return(()=> {
      setFade('')
    })
},[])

  return (
    <>
      <Header></Header>
       <div className={`start ${fade}`}> <Banner></Banner></div>
      <Category></Category>
      <div style={{marginTop:"100px"}}><Footer></Footer> </div>
      <PostButton></PostButton>
    </>
  )
}