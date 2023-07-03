import Category from "../components/body/category/Category";
import PostButton from "../components/postButton/PostButton";
import Banner from "../components/body/banner/Banner";
import {useEffect, useState} from "react";
import {useSearchParams} from "react-router-dom";
import axios from "axios";

export default function ({user, setUser}) {

  let [searchParams, setSearchParams] = useSearchParams();
  const success = searchParams.get("success");
  // let users = null;


  const getUser = () => {
    axios({
      url: "/api/v1/users",
      method: "get"
    }).then((resp) => {
      setUser(resp.data);
      localStorage.setItem("isLoggedIn", "true")
      localStorage.setItem("user", JSON.stringify(resp.data))
    })
  }

  useEffect(() => {
    if (success === '') {
      getUser();
    }
  }, [])

  useEffect(() => {
    console.log(user);
  }, [user])


  const [fade, setFade] = useState('')
  useEffect(() => {
    setTimeout(() => {
      setFade('end')
    }, 100)
    return (() => {
      setFade('')
    })
  }, [])

  return (
    <>
      <div className={`start ${fade}`}><Banner></Banner></div>
      <Category></Category>
      {user ? <PostButton></PostButton> : null}
      <div style={{marginTop: "7rem"}}>
      </div>
    </>
  )
}