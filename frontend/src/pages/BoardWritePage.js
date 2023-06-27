import WriteForm from "../components/body/board/WriteForm"
import Header from "../components/header/Header"
import Footer from "../components/footer/Footer"

export default function ({setPosts}) {

  return (
    <>
      <Header></Header>
      <WriteForm setPosts={setPosts}></WriteForm>
      <div style={{marginTop : "40px"}}> <Footer></Footer> </div>
    </>

  )
}