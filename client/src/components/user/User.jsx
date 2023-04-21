import UserInfo from './UserInfo';
import UserEditForm from './UserEditForm';

function User() {
  return (
    <div className="p-5 w-full h-auto text-black">
      <UserInfo />
      <UserEditForm />
    </div>
  );
}

export default User;
