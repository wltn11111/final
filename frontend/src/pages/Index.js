
import Header from "../components/header/Header";
import Footer from "../components/footer/Footer";
import Category from "../components/body/category/Category";
import PostButton from "../components/postButton/PostButton";
import Banner from "../components/body/banner/Banner";

export default function () {

  return (
    <>
      <Header></Header>
      <Banner></Banner>
      <Category></Category>
      <div style={{marginTop:"100px"}}><Footer></Footer> </div>
      <PostButton></PostButton>
    </>
  )
}