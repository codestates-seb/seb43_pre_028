import ButtonCard from '../ui/ButtonCard';
import PublicInfoEdit from './PublicInfoEdit';
import LinksEdit from './LinksEdit';
import PrivateInfoEdit from './PrivateInfoEdit';

function UserEditForm() {
  return (
    <form>
      <div className="py-5 border-b border-solid border-slate-300 w-auto">
        <h1 className="text-2xl ">Edit your profile</h1>
      </div>
      <PublicInfoEdit />
      <LinksEdit />
      <PrivateInfoEdit />
      <div className="flex itmes-center">
        <ButtonCard className="px-3 h-10 bg-[#1e95ff] hover:bg-[#0074CC] text-white my-8">
          Save profile
        </ButtonCard>
        <ButtonCard className="px-3 h-10 border-0 text-[#1e95ff] my-8 mx-2 hover:bg-[#e1ecf4]">
          Cancel
        </ButtonCard>
      </div>
    </form>
  );
}

export default UserEditForm;
